import { daysAgo, daysAgoRandomized, hoursAgo } from "@/server/utils/date";
import {
  IrisMessageContext,
  IrisMessageDataAttachment,
  IrisMessageDataDiscriminator,
  IrisMessageDataViewData,
  IrisMessageDetails,
  IrisMessageFolder,
  IrisMessageHdContact,
  IrisMessageInsert,
} from "@/api";
import { Request } from "miragejs";
import { getDummyDetailsWithStatus } from "@/server/data/data-requests";
import { EventTrackingMessageDataImportSelection } from "@/modules/event-tracking/modules/message-data/services/normalizer";
import { vaccinationReportList } from "@/server/data/vaccination-reports";
import { VaccinationReportMessageDataImportSelection } from "@/modules/vaccination-report/modules/message-data/services/normalizer";
import { getSchoolEntryExamList } from "@/server/data/school-entry-exam";

export const dummyIrisMessageFolders: IrisMessageFolder[] = [
  {
    id: "inbox",
    name: "Posteingang",
    context: IrisMessageContext.Inbox,
  },
  {
    id: "outbox",
    name: "Postausgang",
    context: IrisMessageContext.Outbox,
  },
];

export const dummyIrisMessageHdContacts: IrisMessageHdContact[] = [
  {
    id: "1",
    name: "Eigenes GA",
    own: true,
  },
  {
    id: "2",
    name: "GA Bickenhain",
  },
  {
    id: "3",
    name: "GA Torfling",
  },
  {
    id: "4",
    name: "GA Densburg",
  },
  {
    id: "5",
    name: "GA Darmburg",
  },
];

export enum DummyMessageDataId {
  EventTracking = "m1_md_et1",
  VaccinationReport = "m1_md_vr1",
  SchoolEntryExam = "m1_md_se_1",
}

export const getDummyIrisMessageViewData = (
  messageDataId: string
): IrisMessageDataViewData => {
  if (messageDataId === DummyMessageDataId.VaccinationReport) {
    return {
      discriminator: IrisMessageDataDiscriminator.VaccinationReport,
      id: messageDataId,
      payload: vaccinationReportList[0],
    };
  }
  if (messageDataId === DummyMessageDataId.SchoolEntryExam) {
    return {
      discriminator: IrisMessageDataDiscriminator.SchoolEntryExam,
      id: messageDataId,
      payload: getSchoolEntryExamList()[0],
    };
  }
  const requestDetails = getDummyDetailsWithStatus("");
  return {
    discriminator: IrisMessageDataDiscriminator.EventTracking,
    id: messageDataId,
    payload: requestDetails,
  };
};

export const getDummyIrisMessageImportSelection = (
  messageDataId: string
): IrisMessageDataViewData => {
  if (messageDataId === DummyMessageDataId.VaccinationReport) {
    return getDummyIrisMessageVRImportSelection(messageDataId);
  }
  if (messageDataId === DummyMessageDataId.SchoolEntryExam) {
    return getDummyIrisMessageSchoolEntryExamImportSelection(messageDataId);
  }
  return getDummyIrisMessageEventImportSelection(messageDataId);
};

const getDummyIrisMessageVRImportSelection = (
  messageDataId: string
): IrisMessageDataViewData => {
  const vaccinationReport = vaccinationReportList[0];
  const employees = vaccinationReport.employees || [];
  const payload: VaccinationReportMessageDataImportSelection = {
    selectables: {
      employees,
    },
    duplicates: {
      employees: [employees?.[0]?.messageDataSelectId || ""].filter((v) => v),
    },
  };
  return {
    discriminator: IrisMessageDataDiscriminator.VaccinationReport,
    id: messageDataId,
    payload,
  };
};

const getDummyIrisMessageSchoolEntryExamImportSelection = (
  messageDataId: string
): IrisMessageDataViewData => {
  return {
    discriminator: IrisMessageDataDiscriminator.SchoolEntryExam,
    id: messageDataId,
    payload: null,
  };
};

const getDummyIrisMessageEventImportSelection = (
  messageDataId: string
): IrisMessageDataViewData => {
  const sourceEvent = getDummyDetailsWithStatus("");
  const guests = sourceEvent.submissionData?.guests || [];
  const payload: EventTrackingMessageDataImportSelection = {
    selectables: {
      guests: guests,
    },
    duplicates: {
      guests: [guests?.[0]?.messageDataSelectId || ""].filter((v) => v),
    },
  };
  return {
    discriminator: IrisMessageDataDiscriminator.EventTracking,
    id: messageDataId,
    payload,
  };
};

export const dummyIrisMessageDataEventTracking: IrisMessageDataAttachment = {
  id: DummyMessageDataId.EventTracking,
  discriminator: IrisMessageDataDiscriminator.EventTracking,
  isImported: false,
  description: "event tracking data attachment",
};

const dummyIrisMessageDataVaccinationReport: IrisMessageDataAttachment = {
  id: DummyMessageDataId.VaccinationReport,
  discriminator: IrisMessageDataDiscriminator.VaccinationReport,
  isImported: false,
  description: "vaccination report data attachment",
};

const dummyIrisMessageDataSchoolEntryExam: IrisMessageDataAttachment = {
  id: DummyMessageDataId.SchoolEntryExam,
  discriminator: IrisMessageDataDiscriminator.SchoolEntryExam,
  isImported: false,
  description: "Mustermann",
};

export const getDummyIrisMessageData = (messageDataId: string) => {
  if (messageDataId === DummyMessageDataId.VaccinationReport) {
    return dummyIrisMessageDataVaccinationReport;
  }
  if (messageDataId === DummyMessageDataId.SchoolEntryExam) {
    return dummyIrisMessageDataSchoolEntryExam;
  }
  return dummyIrisMessageDataEventTracking;
};

export const schoolInboxMessage: IrisMessageDetails = {
  hdAuthor: dummyIrisMessageHdContacts[1],
  hdRecipient: dummyIrisMessageHdContacts[0],
  folder: "inbox",
  context: IrisMessageContext.Inbox,
  id: "m1",
  subject: "Schuleingangsuntersuchung",
  body: "Übermittlung der Untersuchungsdaten für Sophia Mustermann aufgrund von Umzug der Familie Mustermann.",
  createdAt: daysAgo(0),
  isRead: false,
  dataAttachments: [dummyIrisMessageDataSchoolEntryExam],
  attachmentCount: {
    total: 1,
    imported: 0,
  },
};

let dummyIrisMessageList: IrisMessageDetails[] = [
  {
    hdAuthor: dummyIrisMessageHdContacts[0],
    hdRecipient: dummyIrisMessageHdContacts[4],
    folder: "outbox",
    context: IrisMessageContext.Outbox,
    id: "2",
    subject: "Austausch",
    body: "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.",
    createdAt: daysAgoRandomized(1),
    isRead: true,
  },
  {
    hdAuthor: dummyIrisMessageHdContacts[2],
    hdRecipient: dummyIrisMessageHdContacts[0],
    folder: "inbox",
    context: IrisMessageContext.Inbox,
    id: "5",
    subject: "Anfrage",
    body: "At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.",
    createdAt: daysAgoRandomized(4),
    isRead: false,
  },
  {
    hdAuthor: dummyIrisMessageHdContacts[4],
    hdRecipient: dummyIrisMessageHdContacts[0],
    context: IrisMessageContext.Inbox,
    folder: "inbox",
    id: "271",
    subject: "Abstimmung",
    body: "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et",
    createdAt: daysAgoRandomized(5),
    isRead: true,
  },
];

export const getIrisMessageList = (): IrisMessageDetails[] => {
  return dummyIrisMessageList;
};

export const setIrisMessageList = (
  list: IrisMessageDetails[]
): IrisMessageDetails[] => {
  dummyIrisMessageList = list;
  return dummyIrisMessageList;
};

export const getDummyMessageFromRequest = (
  request: Request,
  id?: string
): IrisMessageDetails => {
  const form: IrisMessageInsert = JSON.parse(request.requestBody);
  const subject = form.subject;
  const body = form.body;
  const recipient = form.hdRecipient;
  return {
    id: id || new Date().getTime() + "",
    subject,
    body,
    folder: "outbox",
    isRead: true,
    context: IrisMessageContext.Outbox,
    hdAuthor: dummyIrisMessageHdContacts[0],
    hdRecipient:
      dummyIrisMessageHdContacts.find((c) => c.id === recipient) ||
      dummyIrisMessageHdContacts[1],
    createdAt: hoursAgo(0),
  };
};
