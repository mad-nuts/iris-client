import { SchoolEntryExam } from "@/api";
import { getFormattedDate } from "@/utils/date";
import { join } from "@/utils/misc";

export type SchoolEntryExamTableRow = {
  id?: string;
  child: string;
  parents: string;
  school: string;
  kindergarten: string;
  createdAt: string;
};

export const getSchoolEntryExamTableHeaders = () => [
  { text: "Einschulkind", value: "child", sortable: false },
  { text: "Eltern", value: "parents", sortable: false },
  { text: "Schule", value: "school", sortable: false },
  { text: "Kindergarten", value: "kindergarten", sortable: false },
  { text: "Meldung vom", value: "createdAt", sortable: true },
];

const getName = (item: { name?: string; firstName?: string }): string => {
  return join([item.firstName, item.name], " ");
};

export const getSchoolEntryExamTableRows = (
  items: SchoolEntryExam[] | undefined
): SchoolEntryExamTableRow[] => {
  return (items || []).map((item) => {
    const { child, mother, father } = item;
    return {
      id: item.id,
      child: getName(child),
      parents: getName(mother) + "\n" + getName(father),
      school: child.school || "-",
      kindergarten: child.kindergarten || "-",
      createdAt: getFormattedDate(item.createdAt),
    };
  });
};
