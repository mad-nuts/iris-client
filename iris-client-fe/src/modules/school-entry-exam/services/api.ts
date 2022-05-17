import { apiBundleProvider } from "@/utils/api";
import { DataQuery } from "@/api/common";
import authClient from "@/api-client";
import asyncAction from "@/utils/asyncAction";
import {
  normalizePageSchoolEntryExam,
  normalizeSchoolEntryExam,
} from "@/modules/school-entry-exam/services/normalizer";

const fetchPageSchoolEntryExam = () => {
  const action = async (query: DataQuery) => {
    return normalizePageSchoolEntryExam(
      (await authClient.pageSchoolEntryExamGet({ query })).data,
      true
    );
  };
  return asyncAction(action);
};

const fetchSchoolEntryExamDetails = () => {
  const action = async (id: string) => {
    return normalizeSchoolEntryExam(
      (await authClient.schoolEntryExamDetailsGet(id)).data,
      true
    );
  };
  return asyncAction(action);
};

export const schoolEntryExamApi = {
  fetchPageSchoolEntryExam,
  fetchSchoolEntryExamDetails,
};

export const bundleSchoolEntryExamApi = apiBundleProvider(schoolEntryExamApi);
