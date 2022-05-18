<template>
  <div class="elevation-1 mt-4">
    <template v-for="(attachment, index) in attachments">
      <v-list-item dense :key="`item_${index}`">
        <v-list-item-content>
          <v-list-item-title>
            {{ attachment.name }}
          </v-list-item-title>
          <v-list-item-subtitle v-if="attachment.type">
            {{ attachment.type }}
          </v-list-item-subtitle>
        </v-list-item-content>
        <v-list-item-action>
          <v-btn icon>
            <v-icon>mdi-download</v-icon>
          </v-btn>
        </v-list-item-action>
      </v-list-item>
      <v-divider
        :key="`divider_${index}`"
        v-if="index < attachments.length - 1"
      />
    </template>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import { PropType } from "vue";
import { SchoolEntryExam } from "@/api";

const ExamAttachmentsProps = Vue.extend({
  inheritAttrs: false,
  props: {
    schoolEntryExam: {
      type: Object as PropType<SchoolEntryExam | null>,
      default: null,
    },
  },
});

export interface ExamFileAttachment {
  name: string;
  type?: string;
}

@Component({
  components: {},
})
export default class ExamAttachments extends ExamAttachmentsProps {
  get attachments(): ExamFileAttachment[] {
    return [
      {
        name: "Untersuchungsbericht",
        type: "PDF",
      },
      {
        name: "Angaben zur Gesundheitsvorgeschichte",
        type: "XLS",
      },
    ];
  }
}
</script>
