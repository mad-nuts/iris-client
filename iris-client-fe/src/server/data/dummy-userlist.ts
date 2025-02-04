import { User, UserList, UserRole } from "@/api";
import { Request } from "miragejs";

export const dummyUserList: UserList = {
  users: [
    {
      id: "12345",
      lastName: "Mustermann",
      firstName: "Max",
      userName: "MaxMuster",
      role: UserRole.Admin,
      locked: false,
    },
    {
      id: "abcdef",
      lastName: "Musterfrau",
      firstName: "Lisa",
      userName: "LisaMuster",
      role: UserRole.User,
      locked: false,
    },
    {
      id: "67890",
      lastName: "Person",
      firstName: "Test",
      userName: "TestUser",
      role: UserRole.User,
      locked: true,
    },
    {
      id: "321654",
      lastName: "E2EUser",
      firstName: "E2ETest",
      userName: "E2ETestUser",
      role: UserRole.User,
      locked: false,
    },
  ],
};

export const getDummyUserFromRequest = (
  request: Request,
  id?: string
): User => {
  const { firstName, lastName, userName, role, oldPassword, locked } =
    JSON.parse(request.requestBody);
  if (oldPassword === "p") {
    throw new Error("Das bisherige Passwort stimmt nicht!");
  }
  return {
    id: id || new Date().getTime() + "",
    firstName,
    lastName,
    userName,
    role,
    locked,
  };
};
