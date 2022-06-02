<template>
  <div class="home">
    <h2 class="light-font mb-6 text-center">
      Herzlich willkommen bei IRIS connect - Die öffentliche Datenschnittstelle
      des Gesundheitsamts
    </h2>
    <v-row>
      <v-col cols="6" offset="3">
        <counter-widget
          subtitle="Schuleingangsuntersuchungen"
          :count="openSchoolExams"
          actionlabel="Zur Übersicht"
          image="sketch_reviewed_docs.svg"
          actionlink="school-entry-exam/list"
        ></counter-widget>
      </v-col>
      <v-col cols="6" offset="3">
        <counter-widget
          :subtitle="`ungelesene ${
            unreadMessageCount === 1 ? 'Nachricht' : 'Nachrichten'
          }`"
          :count="unreadMessageCount"
          actionlabel="Zum Postfach"
          image="sketch_file_analysis.svg"
          actionlink="iris-messages/list"
        ></counter-widget>
      </v-col>
    </v-row>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import CounterWidget from "@/components/dashboard/counter-widget.vue";
// import CasesBarChart from "@/components/dashboard/cases-bar-chart.vue";
// import CasesPieChart from "@/components/dashboard/cases-pie-chart.vue";
import EventList from "@/components/event-list.vue";
import store from "@/store";
import { ExistingDataRequestClientWithLocation, Statistics } from "@/api";
import { TableRow } from "@/components/event-list.vue";
import { ErrorMessage } from "@/utils/axios";
import StatusColors from "@/constants/StatusColors";
import StatusMessages from "@/constants/StatusMessages";
import { join } from "@/utils/misc";
import { getSchoolEntryExamList } from "@/server/data/school-entry-exam";
import { fetchUnreadMessageCountApi } from "@/modules/iris-message/services/api";

const tableRowMapper = (
  dataRequest: ExistingDataRequestClientWithLocation
): TableRow => {
  return {
    address: getFormattedAddress(dataRequest),
    endTime: getFormattedDate(dataRequest.end),
    startTime: getFormattedDate(dataRequest.start),
    generatedTime: getFormattedDate(dataRequest.requestedAt),
    lastChange: getFormattedDate(dataRequest.lastUpdatedAt),
    extID: dataRequest.externalRequestId || "-",
    code: dataRequest.code || "-",
    name: dataRequest.name || "-",
    status: dataRequest.status?.toString() || "-",
    statusColor: StatusColors.getColor(dataRequest.status),
    statusName: StatusMessages.getMessage(dataRequest.status),
  };
};

function getFormattedAddress(
  data?: ExistingDataRequestClientWithLocation
): string {
  const contact = data?.locationInformation?.contact;
  if (!contact) return data?.locationInformation?.name || data?.name || "-";
  return join(
    [
      contact?.officialName,
      contact?.address?.street,
      join([contact?.address?.zip, contact?.address?.city], " "),
    ],
    ", "
  );
}

function getFormattedDate(date?: string): string {
  return date
    ? `${new Date(date).toDateString()}, ${new Date(date).toLocaleTimeString()}`
    : "-";
}

@Component({
  components: {
    EventList,
    // CasesPieChart,
    // CasesBarChart,
    CounterWidget,
  },
  async beforeRouteEnter(_from, _to, next) {
    next();
    await store.dispatch("home/fetchEventTrackingList");
    await store.dispatch("home/fetchStatistics");
  },
  beforeRouteLeave(to, from, next) {
    store.commit("home/reset");
    next();
  },
})
export default class Home extends Vue {
  get eventTrackingListError(): ErrorMessage {
    return store.state.home.eventTrackingListError;
  }

  get openSchoolExams(): number {
    return getSchoolEntryExamList().length;
  }

  get unreadMessageCount(): number {
    return fetchUnreadMessageCountApi.state.result ?? 0;
  }

  get openEventListData(): TableRow[] {
    const dataRequests = store.state.home.eventTrackingList || [];
    return dataRequests.map(tableRowMapper);
  }

  get statistics(): Statistics {
    return store.state.home.statistics;
  }
}
</script>

<style lang="scss" scoped>
.home {
  > * {
    margin-top: 1em;

    &:last-child {
      margin-bottom: 1em;
    }
  }
}
</style>
