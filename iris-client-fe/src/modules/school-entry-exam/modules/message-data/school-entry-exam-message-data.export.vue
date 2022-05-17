<template>
  <div>
    <v-input
      :value="model.exam"
      :rules="validationRules.defined"
      hide-details="auto"
    >
      <div class="w-100">
        <select-exam
          :value="model.exam"
          @input="onExamChange"
          :description="description"
          :disabled="disabled"
          @update:description="$emit('update:description', $event)"
        />
      </div>
    </v-input>
  </div>
</template>

<script lang="ts">
import { Component, Vue, Watch } from "vue-property-decorator";
import { IrisMessageDataSelectionPayload } from "@/api";
import { PropType } from "vue";
import rules from "@/common/validation-rules";
import _values from "lodash/values";
import _every from "lodash/every";
import SelectExam from "@/modules/school-entry-exam/modules/message-data/components/select-exam.vue";

const SchoolEntryExamMessageDataExportProps = Vue.extend({
  inheritAttrs: false,
  props: {
    description: {
      type: String,
      default: "",
    },
    value: {
      type: Object as PropType<IrisMessageDataSelectionPayload | null>,
      default: null,
    },
    disabled: {
      type: Boolean,
      default: false,
    },
  },
});

@Component({
  components: {
    SelectExam,
  },
})
export default class SchoolEntryExamMessageDataExport extends SchoolEntryExamMessageDataExportProps {
  step = 1;

  model: IrisMessageDataSelectionPayload = this.value || {
    exam: "",
  };

  @Watch("model", { immediate: true, deep: true })
  onModelChange(newValue: IrisMessageDataSelectionPayload) {
    if (_every(_values(newValue), (v) => rules.defined(v) === true)) {
      this.$emit("input", newValue);
    } else {
      this.$emit("input", null);
    }
  }

  onExamChange(value: string) {
    if (value === this.model.exam) return;
    this.model.exam = value;
  }

  get validationRules(): Record<string, Array<unknown>> {
    return {
      defined: [rules.defined],
    };
  }
}
</script>

<style scoped>
.w-100 {
  width: 100%;
}
</style>
