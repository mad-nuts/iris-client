import {
  Address,
  SchoolEntryChild,
  SchoolEntryExam,
  SchoolEntryParent,
  Sex,
} from "@/api";
import _sample from "lodash/sample";
import _random from "lodash/random";
import { timeAgo } from "@/server/utils/date";

const createAddress = (): Address => {
  return {
    street: _sample(["Dunkle Gasse", "Hauptstraße", "Testweg", "Tastallee"]),
    houseNumber: `${_random(1, 20)}`,
    zipCode: `${_random(10000, 99999)}`,
    city: _sample(["Musterhausen", "Testort", "Testing", "Einsiedlerhof"]),
  };
};

const getFirstName = (gender: Sex): string | undefined => {
  switch (gender) {
    case Sex.Male:
      return _sample(["Max", "Klaus", "Gunner"]);
    case Sex.Female:
      return _sample(["Bärbel", "Gabi", "Lena"]);
    default:
      return "Uli";
  }
};

const createParent = (
  gender: Sex,
  partner?: SchoolEntryParent
): SchoolEntryParent => {
  return {
    name: partner?.name ?? _sample(["Muster", "Kulli", "Glasklar", "Taff"]),
    firstName: getFirstName(gender),
    address: partner?.address ?? createAddress(),
    graduation: _sample(["Hauptschulabschluss", "Mittlere Reife", "Abitur"]),
    nationality: "deutsch",
    birthday: timeAgo(_random(25, 40), "years"),
    birthLocation: _sample([
      "Musterhausen",
      "Testort",
      "Testing",
      "Einsiedlerhof",
    ]),
  };
};

const createChild = (parent: SchoolEntryParent): SchoolEntryChild => {
  return {
    name: parent.name,
    firstName: _sample(["Max", "Gustav", "Gabi", "Lena", "Klaus"]),
    address: parent.address,
    birthday: timeAgo(_random(5, 7), "years"),
    birthLocation: _sample([
      "Musterhausen",
      "Testort",
      "Testing",
      "Einsiedlerhof",
    ]),
    kindergarten: _sample([
      "Musterkindergarten",
      "Testhort",
      "Outdoor Kindergarten",
    ]),
    school: _sample([
      "Musterschule",
      "Test Gesamtschule",
      "Grundschule Musterort",
    ]),
  };
};

const createExam = (id: string): SchoolEntryExam => {
  const mother = createParent(Sex.Female);
  return {
    id,
    mother,
    father: createParent(Sex.Male, mother),
    child: createChild(mother),
    createdAt: timeAgo(_random(2, 25), "days"),
  };
};

export const schoolEntryExamList: SchoolEntryExam[] = [
  createExam("1"),
  createExam("2"),
  createExam("3"),
  createExam("4"),
  createExam("5"),
];
