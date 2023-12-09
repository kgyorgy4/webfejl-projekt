package com.example.springbackend.dto;

public class EmployeeSaveDTO {



        private String first_name;

        private String last_name;

        private String email;

        public EmployeeSaveDTO(String first_name, String last_name, String email) {
            this.first_name = first_name;
            this.last_name = last_name;
            this.email = email;
        }

        public EmployeeSaveDTO() {
        }


        public String getfirst_name() {
            return first_name;
        }

        public void setfirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getlast_name() {
            return last_name;
        }

        public void setlast_name(String last_name) {
            this.last_name = last_name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return "EmployeeDTO{" +
                    ", first_name='" + first_name + '\'' +
                    ", last_name='" + last_name + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }


}
