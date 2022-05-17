<template>
  <school-entry-exam-details-component :school-entry-exam="payload" />
</template>
<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import { PropType } from "vue";
import { SchoolEntryExam } from "@/api";
import SchoolEntryExamDetailsComponent from "@/modules/school-entry-exam/views/details/components/school-entry-exam-details.component.vue";

const SchoolEntryExamMessageDataPreviewProps = Vue.extend({
  props: {
    payload: {
      type: Object as PropType<SchoolEntryExam | null>,
      default: null,
    },
  },
});

@Component({
  components: {
    SchoolEntryExamDetailsComponent,
  },
})
export default class SchoolEntryExamMessageDataPreview extends SchoolEntryExamMessageDataPreviewProps {}
</script>
