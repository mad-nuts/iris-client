<template>
  <data-export-dialog
    title="Daten"
    :items="exportFormatList"
    @export-csv-standard="exportStandard('csv')"
    @export-xlsx-standard="exportStandard('xlsx')"
  >
    <template #activator="{ attrs, on }">
      <v-btn
        v-on="on"
        v-bind="attrs"
        color="primary"
        data-test="export-dialog.activator"
      >
        exportieren
      </v-btn>
    </template>
  </data-export-dialog>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import { PropType } from "vue";
import { SchoolEntryExam } from "@/api";
import InfoGrid from "@/components/info-grid.vue";
import DataExportDialog, {
  DataExportFormat,
} from "@/components/data-export/data-export-dialog.vue";
import { ExportFileType } from "@/utils/data-export/data-export";
import { getFormattedDate } from "@/utils/date";
import exportStandard from "@/modules/vaccination-report/views/details/modules/data-export/services/exportStandard";

const SchoolEntryExamDataExportProps = Vue.extend({
  inheritAttrs: false,
  props: {
    exam: {
      type: Object as PropType<SchoolEntryExam | null>,
      default: null,
    },
  },
});

@Component({
  components: {
    DataExportDialog,
    InfoGrid,
  },
})
export default class SchoolEntryExamDataExport extends SchoolEntryExamDataExportProps {
  exportFormatList: DataExportFormat[] = [
    {
      label: "Standard",
      csv: {
        action: "export-csv-standard",
        test: "export.csv.standard",
      },
      xlsx: {
        action: "export-xlsx-standard",
        test: "export.xlsx.standard",
      },
    },
  ];
  exportStandard(type: ExportFileType): void {
    const fileName = [
      "Export",
      getFormattedDate(new Date(), "YYYY-MM-DD_HHmm"),
    ].join("_");
    const exporter =
      type === "xlsx" ? exportStandard.exportXlsx : exportStandard.exportCsv;
    exporter([{ exam: "test" }], fileName);
  }
}
</script>
