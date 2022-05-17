<template>
  <div>
    <v-row no-gutters>
      <v-col cols="3"></v-col>
      <v-col cols="9">
        <v-row no-gutters>
          <v-col cols="6"><strong>Mutter:</strong></v-col>
          <v-col cols="6"><strong>Vater:</strong></v-col>
        </v-row>
      </v-col>
    </v-row>
    <v-row no-gutters :key="index" v-for="(header, index) in headers">
      <v-col cols="3" class="caption">{{ header }}:</v-col>
      <v-col cols="9">
        <v-row no-gutters>
          <v-col cols="6">{{ mother[index] || "-" }}</v-col>
          <v-col cols="6">{{ father[index] || "-" }}</v-col>
        </v-row>
      </v-col>
    </v-row>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import { SchoolEntryExam, SchoolEntryParent } from "@/api";
import { PropType } from "vue";
import { getFormattedDate } from "@/utils/date";

const ParentInfoProps = Vue.extend({
  inheritAttrs: false,
  props: {
    schoolEntryExam: {
      type: Object as PropType<SchoolEntryExam | null>,
      default: null,
    },
  },
});

@Component({
  components: {},
})
export default class ParentInfo extends ParentInfoProps {
  get headers(): string[] {
    return ["Name", "Nationalität", "Geburtsdatum", "Geburtsort", "Adresse"];
  }
  get mother(): string[] {
    return this.getParent(this.schoolEntryExam?.mother);
  }
  get father(): string[] {
    return this.getParent(this.schoolEntryExam?.father);
  }
  getParent(parent?: SchoolEntryParent): string[] {
    return [
      [parent?.firstName ?? "", parent?.name ?? ""].join(" ").trim(),
      parent?.nationality ?? "",
      getFormattedDate(parent?.birthday, "L") ?? "",
      parent?.birthLocation ?? "",
      "siehe Kind",
    ];
  }
}
</script>
