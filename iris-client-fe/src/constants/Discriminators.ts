import { IrisMessageDataDiscriminator } from "@/api";

const getLabel = (discriminator: IrisMessageDataDiscriminator): string => {
  switch (discriminator) {
    case IrisMessageDataDiscriminator.EventTracking:
      return "Ereignis";
    case IrisMessageDataDiscriminator.VaccinationReport:
      return "Impfpflichtmeldung";
    case IrisMessageDataDiscriminator.SchoolEntryExam:
      return "Schuleingangsuntersuchung";
    default:
      return "Ungültiger Datentyp";
  }
};

const Discriminators = {
  getLabel,
};

export default Discriminators;
