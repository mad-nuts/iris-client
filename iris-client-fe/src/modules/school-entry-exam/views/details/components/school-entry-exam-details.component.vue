<template>
  <v-card>
    <v-card-title> Schuleingangsuntersuchung </v-card-title>
    <v-card-text>
      <info-grid :content="dateInfo" />
      <info-grid :content="childInfo" />
      <v-divider class="my-4" />
      <v-row>
        <v-col cols="12">
          <child-info :item="child" />
        </v-col>
      </v-row>
      <v-divider class="my-4" />
      <v-row>
        <v-col cols="12">
          <span class="mr-3">
            <strong>Eltern:</strong>
          </span>
          <parent-info :school-entry-exam="schoolEntryExam" />
        </v-col>
      </v-row>
      <error-message-alert :errors="errors" />
    </v-card-text>
    <v-divider />
    <slot name="actions" />
  </v-card>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import ErrorMessageAlert from "@/components/error-message-alert.vue";
import { SchoolEntryExam } from "@/api";
import InfoGrid from "@/components/info-grid.vue";
import { getFormattedDate } from "@/utils/date";
import BtnToggleSelect from "@/components/btn-toggle-select.vue";
import { PropType } from "vue";
import ExpandableDataTable from "@/components/expandable-data-table.vue";
import ParentInfo from "@/modules/school-entry-exam/views/details/components/parent-info.vue";
import ChildInfo from "@/modules/school-entry-exam/views/details/components/child-info.vue";

const SchoolEntryExamDetailsComponentProps = Vue.extend({
  inheritAttrs: false,
  props: {
    schoolEntryExam: {
      type: Object as PropType<SchoolEntryExam | null>,
      default: null,
    },
    loading: {
      type: Boolean,
      default: false,
    },
    errors: {
      type: [Array, String],
      default: () => [],
    },
  },
});

@Component({
  components: {
    ChildInfo,
    ParentInfo,
    ExpandableDataTable,
    BtnToggleSelect,
    InfoGrid,
    ErrorMessageAlert,
  },
})
export default class SchoolEntryExamDetailsComponent extends SchoolEntryExamDetailsComponentProps {
  get dateInfo() {
    return [
      [["Meldung vom", getFormattedDate(this.schoolEntryExam?.createdAt)]],
    ];
  }
  get child() {
    return this.schoolEntryExam?.child;
  }
  get childInfo() {
    return [
      [
        ["Schule", this.schoolEntryExam?.child.school ?? ""],
        ["Kindergarten", this.schoolEntryExam?.child.kindergarten ?? ""],
      ],
    ];
  }
}
</script>
