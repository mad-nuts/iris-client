<template>
  <div>
    <v-row no-gutters>
      <v-col cols="12"><strong>Einschulkind:</strong></v-col>
    </v-row>
    <v-row no-gutters :key="rowIndex" v-for="(row, rowIndex) in content">
      <v-col cols="3" class="caption">
        {{ row[0] }}
      </v-col>
      <v-col cols="9" class="text-pre-line">
        {{ row[1] || "-" }}
      </v-col>
    </v-row>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import { SchoolEntryChild } from "@/api";
import { PropType } from "vue";
import { getFormattedDate } from "@/utils/date";
import { getFormattedAddress } from "@/utils/address";

const ChildInfoProps = Vue.extend({
  inheritAttrs: false,
  props: {
    item: {
      type: Object as PropType<SchoolEntryChild | null>,
      default: null,
    },
  },
});

@Component({
  components: {},
})
export default class ChildInfo extends ChildInfoProps {
  get content(): string[][] {
    return [
      [
        "Name:",
        [this.item?.firstName ?? "", this.item?.name ?? ""].join(" ").trim(),
      ],
      ["Geburtsdatum:", getFormattedDate(this.item?.birthday, "L") ?? ""],
      ["Geburtsort:", this.item?.birthLocation ?? ""],
      ["Adresse:", getFormattedAddress(this.item?.address)],
    ].filter((v) => !!v);
  }
}
</script>
