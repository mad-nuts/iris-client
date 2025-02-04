<template>
  <v-layout justify-center>
    <v-card class="my-3 user-login-container">
      <v-form
        ref="form"
        v-model="formIsValid"
        lazy-validation
        :disabled="isDisabled"
      >
        <v-card-title>Anmelden</v-card-title>
        <v-card-text>
          <v-row>
            <v-col cols="12">
              <v-text-field
                v-model="formModel.userName"
                :rules="validationRules.sanatisedAndDefined"
                label="Anmeldename"
                data-test="userName"
              ></v-text-field>
            </v-col>
            <v-col cols="12">
              <v-text-field
                v-model="formModel.password"
                :rules="validationRules.password"
                label="Passwort"
                type="password"
                @keyup.native.enter="submit"
                data-test="password"
              ></v-text-field>
            </v-col>
          </v-row>
          <user-login-error :error="authenticationError" />
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn
            :disabled="isDisabled"
            color="primary"
            @click="submit"
            data-test="submit"
          >
            Anmelden
          </v-btn>
        </v-card-actions>
      </v-form>
    </v-card>
  </v-layout>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import store from "@/store";
import { ErrorMessage } from "@/utils/axios";
import { Credentials } from "@/api";
import rules from "@/common/validation-rules";
import UserLoginError from "@/views/user-login/components/user-login-error.vue";

@Component({
  components: {
    UserLoginError,
  },
  beforeRouteLeave(to, from, next) {
    store.commit("userLogin/reset");
    next();
  },
})
export default class UserLoginView extends Vue {
  $refs!: {
    form: HTMLFormElement;
  };

  formIsValid = true;

  formModel: Credentials = {
    userName: "",
    password: "",
  };

  get authenticationError(): ErrorMessage {
    return this.$store.state.userLogin.authenticationError;
  }

  get validationRules(): Record<string, Array<unknown>> {
    return {
      sanatisedAndDefined: [rules.defined, rules.sanitised],
      password: [rules.defined, rules.sanitised],
    };
  }

  get isDisabled(): boolean {
    return this.$store.state.userLogin.authenticating;
  }

  async submit(): Promise<void> {
    const valid = this.$refs.form.validate() as boolean;
    if (valid) {
      await store.dispatch("userLogin/authenticate", this.formModel);
      await this.$router.push(store.state.userLogin.interceptedRoute);
    }
  }
}
</script>

<style scoped>
.user-login-container {
  max-width: 420px;
}
</style>
