<template>
  <school-entry-exam-details-component
    class="my-7"
    :loading="fetchDetails.state.loading"
    :errors="fetchDetails.state.error"
    :school-entry-exam="schoolEntryExam"
  >
    <template #actions>
      <v-divider />
      <v-card-actions>
        <v-btn text @click="goBack"> Zurück </v-btn>
        <v-spacer />
        <data-export-label
          :selected="1"
          :total="1"
          :label="['Daten']"
          :action-label="false"
          #default="{ exportLabel }"
        >
          <span class="mr-3">
            {{ exportLabel }}
          </span>
        </data-export-label>
        <school-entry-exam-data-export :exam="schoolEntryExam" />
        <iris-message-data-export-dialog :data="messageData" label="senden" />
      </v-card-actions>
    </template>
  </school-entry-exam-details-component>
</template>

<script lang="ts">
import { Component, Mixins } from "vue-property-decorator";
import { IrisMessageDataDiscriminator, IrisMessageDataInsert } from "@/api";
import HistoryBack from "@/mixins/HistoryBack";
import DataExportLabel from "@/components/data-export/data-export-label.vue";
import IrisMessageDataExportDialog from "@/views/iris-message-create/components/iris-message-data-export-dialog.vue";
import { schoolEntryExamApi } from "@/modules/school-entry-exam/services/api";
import SchoolEntryExamDetailsComponent from "@/modules/school-entry-exam/views/details/components/school-entry-exam-details.component.vue";
import SchoolEntryExamDataExport from "@/modules/school-entry-exam/views/details/modules/data-export/components/school-entry-exam-data-export.vue";

@Component({
  components: {
    SchoolEntryExamDataExport,
    SchoolEntryExamDetailsComponent,
    IrisMessageDataExportDialog,
    DataExportLabel,
  },
})
export default class SchoolEntryExamDetailsView extends Mixins(
  HistoryBack("school-entry-exam-list")
) {
  fetchDetails = schoolEntryExamApi.fetchSchoolEntryExamDetails();
  mounted() {
    this.fetchDetails.execute(this.$route.params.id);
  }

  get messageData(): IrisMessageDataInsert {
    return {
      discriminator: IrisMessageDataDiscriminator.SchoolEntryExam,
      description: this.schoolEntryExam?.child.name || "",
      payload: {
        exam: this.schoolEntryExam?.id || "",
      },
    };
  }

  get schoolEntryExam() {
    return this.fetchDetails.state.result;
  }
}
</script>
