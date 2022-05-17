<template>
  <div>
    <v-input
      :value="model.target"
      :rules="validationRules.defined"
      hide-details="auto"
    >
      <div class="w-100">
        <select-exam
          :value="model.target"
          @input="onTargetChange"
          :disabled="disabled"
        />
      </div>
    </v-input>
  </div>
</template>

<script lang="ts">
import { Component, Vue, Watch } from "vue-property-decorator";
import { PropType } from "vue";
import rules from "@/common/validation-rules";
import { IrisMessageDataSelectionPayload } from "@/api";
import _every from "lodash/every";
import SelectExam from "@/modules/school-entry-exam/modules/message-data/components/select-exam.vue";

type ImportValue = {
  target?: string;
  selection: Record<string, unknown>;
};

const SchoolEntryExamMessageDataImportProps = Vue.extend({
  props: {
    value: {
      type: Object as PropType<Partial<ImportValue> | null>,
      default: null,
    },
    payload: {
      type: Object as PropType<null>,
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
export default class SchoolEntryExamMessageDataImport extends SchoolEntryExamMessageDataImportProps {
  step = 1;

  model: ImportValue = {
    target: this.value?.target,
    selection: {},
  };

  @Watch("model", { immediate: true, deep: true })
  onModelChange(newValue: IrisMessageDataSelectionPayload) {
    if (_every([this.model.target], (v) => rules.defined(v) === true)) {
      this.$emit("input", newValue);
    } else {
      this.$emit("input", null);
    }
  }

  onTargetChange(value: string) {
    if (value === this.model.target) return;
    this.model.target = value;
    this.$emit("update:target", value);
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
