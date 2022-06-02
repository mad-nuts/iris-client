<template>
  <div class="school-entry-exam-tabs">
    <v-tabs v-model="tab">
      <v-tab>Übersicht</v-tab>
      <v-tab>Statistiken</v-tab>
    </v-tabs>
    <v-tabs-items v-model="tab">
      <v-tab-item>
        <school-entry-exam-list-view />
      </v-tab-item>
      <v-tab-item>
        <v-card class="my-7">
          <v-card-title>
            Schuleingangsuntersuchungen: Statistiken
          </v-card-title>
          <iframe
            class="responsive-iframe"
            src="http://localhost:3000/statistics-frame"
          ></iframe>
        </v-card>
      </v-tab-item>
    </v-tabs-items>
  </div>
</template>
<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import SchoolEntryExamListView from "@/modules/school-entry-exam/views/list/school-entry-exam-list.view.vue";

@Component({
  components: {
    SchoolEntryExamListView,
  },
})
export default class SchoolEntryExamListTabView extends Vue {
  tab = null;
}
</script>

<style lang="scss">
.school-entry-exam-tabs {
  .responsive-iframe {
    border: 0;
    width: 100%;
    height: 70vh;
  }
  .theme--light.v-tabs > .v-tabs-bar,
  .theme--light.v-tabs-items {
    background-color: transparent !important;
  }
}
</style>
