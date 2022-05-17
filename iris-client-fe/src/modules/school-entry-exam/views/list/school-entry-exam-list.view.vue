<template>
  <v-card class="my-7">
    <v-card-title> Schuleingangsuntersuchungen </v-card-title>
    <v-card-text>
      <data-query-handler
        @update:query="handleQueryUpdate"
        #default="{ query }"
      >
        <search-field v-model="query.search" />
        <sortable-data-table
          class="mt-5"
          :item-class="() => 'cursor-pointer'"
          :headers="tableHeaders"
          :sort.sync="query.sort"
          :items="tableRows"
          :loading="fetchPage.state.loading"
          :page.sync="query.page"
          :items-per-page.sync="query.size"
          :server-items-length="totalElements"
          @click:row="handleRowClick"
          data-test="view.data-table"
        >
          <template v-slot:item.parents="{ item }">
            <span class="text-pre-line"> {{ item.parents }} </span>
          </template>
        </sortable-data-table>
        <error-message-alert :errors="fetchPage.state.error" />
      </data-query-handler>
    </v-card-text>
  </v-card>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import DataQueryHandler from "@/components/pageable/data-query-handler.vue";
import SearchField from "@/components/pageable/search-field.vue";
import SortableDataTable from "@/components/sortable-data-table.vue";
import ErrorMessageAlert from "@/components/error-message-alert.vue";
import { DataQuery } from "@/api/common";
import { schoolEntryExamApi } from "@/modules/school-entry-exam/services/api";
import {
  getSchoolEntryExamTableHeaders,
  getSchoolEntryExamTableRows,
} from "@/modules/school-entry-exam/services/mappedData";

@Component({
  components: {
    ErrorMessageAlert,
    SortableDataTable,
    SearchField,
    DataQueryHandler,
  },
})
export default class SchoolEntryExamListView extends Vue {
  tableHeaders = getSchoolEntryExamTableHeaders();
  fetchPage = schoolEntryExamApi.fetchPageSchoolEntryExam();
  handleQueryUpdate(newValue: DataQuery) {
    if (newValue) {
      this.fetchPage.execute(newValue);
    } else {
      this.fetchPage.reset(["result"]);
    }
  }
  get tableRows() {
    return getSchoolEntryExamTableRows(this.fetchPage.state.result?.content);
  }
  get totalElements(): number | undefined {
    return this.fetchPage.state.result?.totalElements;
  }
  handleRowClick(row: { id?: string }) {
    if (row.id) {
      this.$router.push({
        name: "school-entry-exam-details",
        params: { id: row.id },
      });
    }
  }
}
</script>
