<template>
  <single-select-query-data-table
    @update:query="handleQueryUpdate"
    v-bind="$attrs"
    v-on="$listeners"
    @input="handleInput"
    :headers="tableHeaders"
    :items="tableRows"
    :server-items-length="totalElements"
    :loading="fetchPage.state.loading"
    :errors="[fetchPage.state.error]"
  >
    <template v-slot:item.parents="{ item }">
      <span class="text-pre-line"> {{ item.parents }} </span>
    </template>
  </single-select-query-data-table>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import { DataQuery } from "@/api/common";
import SingleSelectQueryDataTable from "@/modules/iris-message/modules/message-data/components/single-select-query-data-table.vue";
import { getDefaultDescription } from "@/modules/vaccination-report/modules/message-data/services/utils";
import { schoolEntryExamApi } from "@/modules/school-entry-exam/services/api";
import {
  getSchoolEntryExamTableHeaders,
  getSchoolEntryExamTableRows,
} from "@/modules/school-entry-exam/services/mappedData";

const SelectReportProps = Vue.extend({
  inheritAttrs: false,
  props: {
    description: {
      type: String,
      default: "",
    },
  },
});
@Component({
  components: {
    SingleSelectQueryDataTable,
  },
})
export default class SelectReport extends SelectReportProps {
  tableHeaders = getSchoolEntryExamTableHeaders();
  fetchPage = schoolEntryExamApi.fetchPageSchoolEntryExam();

  get tableRows() {
    return getSchoolEntryExamTableRows(this.fetchPage.state.result?.content);
  }

  handleInput(value: string) {
    if (!this.description) {
      const match = this.tableRows.find((row) => row.id === value);
      this.$emit("update:description", getDefaultDescription(match));
    }
  }

  handleQueryUpdate(query: DataQuery) {
    this.fetchPage.execute(query);
  }

  get totalElements(): number | undefined {
    return this.fetchPage.state.result?.totalElements;
  }
}
</script>
