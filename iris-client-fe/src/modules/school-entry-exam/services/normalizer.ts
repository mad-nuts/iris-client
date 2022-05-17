import {
  Page,
  SchoolEntryChild,
  SchoolEntryExam,
  SchoolEntryParent,
} from "@/api";
import { normalizeData } from "@/utils/data";
import {
  normalizeAddress,
  normalizeMetaData,
  normalizePage,
} from "@/common/normalizer";

export const normalizeParent = (
  source?: SchoolEntryParent,
  parse?: boolean
) => {
  return normalizeData(
    source,
    (normalizer) => {
      return {
        name: normalizer("name", ""),
        firstName: normalizer("firstName", ""),
        address: normalizeAddress(source?.address),
        birthLocation: normalizer("birthLocation", ""),
        birthday: normalizer("birthday", undefined, "dateString"),
        nationality: normalizer("nationality", ""),
        graduation: normalizer("graduation", ""),
      };
    },
    parse,
    "SchoolEntryParent"
  );
};

export const normalizeSchoolEntryChild = (
  source?: SchoolEntryChild,
  parse?: boolean
) => {
  return normalizeData(
    source,
    (normalizer) => {
      return {
        name: normalizer("name", ""),
        firstName: normalizer("firstName", ""),
        address: normalizeAddress(source?.address),
        birthLocation: normalizer("birthLocation", ""),
        birthday: normalizer("birthday", undefined, "dateString"),
        school: normalizer("school", ""),
        kindergarten: normalizer("kindergarten", ""),
      };
    },
    parse,
    "SchoolEntryChild"
  );
};

export const normalizeSchoolEntryExam = (
  source?: SchoolEntryExam,
  parse?: boolean
) => {
  return normalizeData(
    source,
    (normalizer) => {
      return {
        id: normalizer("id", ""),
        child: normalizeSchoolEntryChild(source?.child),
        mother: normalizeParent(source?.mother),
        father: normalizeParent(source?.father),
        ...normalizeMetaData(source),
      };
    },
    parse,
    "SchoolEntryExam"
  );
};

export const normalizePageSchoolEntryExam = (
  source?: Page<SchoolEntryExam>,
  parse?: boolean
) => {
  return normalizePage(normalizeSchoolEntryExam, source, parse);
};
