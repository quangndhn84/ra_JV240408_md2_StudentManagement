package ra.entity;

import ra.run.StudentManagement;

import java.util.Scanner;

public class Student {
    //1. Fields/Attributes/Properties
    private String studentId;
    private String studentName;
    private int age;
    private boolean sex;
    private String address;
    private String phone;
    //2. Constructors

    public Student() {
    }

    public Student(String studentId, String studentName, int age, boolean sex, String address, String phone) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
    }
    //3. Method
    //-3.1. Getter/Setter

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //-3.2. Method Behavior
    public void inputData(Scanner scanner) {
        //1. Nhập mã sinh viên: gồm 5 ký tự bắt đầu là SV, không trùng lặp
        this.studentId = inputStudentId(scanner);
        //2. Nhập tên sinh viên: Phải có từ 6 đến 50 ký tự
        this.studentName = inputStudentName(scanner);
        //3. Tuổi sinh viên phải có giá trị lớn hơn hoặc bằng 18
        this.age = inputAge(scanner);
        //4. Giới tính chỉ nhận giá trị true/false
        this.sex = inputSex(scanner);
        //5. Địa chỉ: không được rỗng
        this.address = inputAddress(scanner);
        //6. Điện thoại: gồm 10 ký tự bắt đầu là ký tự 0, không trùng lặp
        this.phone = inputPhone(scanner);
    }

    public String inputStudentId(Scanner scanner) {
        System.out.println("Nhập vào mã sinh viên:");
        do {
            String studentId = scanner.nextLine();
            if (studentId.length() == 5) {
                if (studentId.startsWith("SV")) {
                    //Không trùng lặp
                    boolean isExist = false;//Chưa tồn tại
                    for (int i = 0; i < StudentManagement.currentIndex; i++) {
                        if (StudentManagement.arrStudents[i].getStudentId().equals(studentId)) {
                            isExist = true;//đã tồn tại
                            break;
                        }
                    }

                    if (isExist) {
                        //Đã tồn tại
                        System.err.println("Mã sinh viên đã tồn tại, vui lòng nhập lại");
                    } else {
                        return studentId;
                    }
                } else {
                    System.err.println("Mã sinh viên bắt đầu là SV, vui lòng nhập lại");
                }
            } else {
                System.err.println("Mã sinh viên gồm 5 ký tự, vui lòng nhập lại");
            }
        } while (true);
    }

    public String inputStudentName(Scanner scanner) {
        System.out.println("Nhập vào tên sinh viên:");
        do {
            String studentName = scanner.nextLine();
            if (studentName.length() >= 6 && studentName.length() <= 50) {
                return studentName;
            } else {
                System.err.println("Tên sinh viên từ 6-50 ký tự, vui lòng nhập lại");
            }
        } while (true);
    }

    public int inputAge(Scanner scanner) {
        System.out.println("Nhập vào tuổi sinh viên: ");
        do {
            int age = Integer.parseInt(scanner.nextLine());
            if (age >= 18) {
                return age;
            } else {
                System.err.println("Sinh viên phải có tuổi lớn hơn hoặc bằng 18, vui lòng nhập lại");
            }
        } while (true);
    }

    public boolean inputSex(Scanner scanner) {
        System.out.println("Nhập vào giới tính sinh viên:");
        do {
            String sex = scanner.nextLine();
            if (sex.equals("true") || sex.equals("false")) {
                return Boolean.parseBoolean(sex);
            } else {
                System.err.println("Giới tính sinh viên chỉ nhận giá trị true|false, vui lòng nhập lại");
            }
        } while (true);
    }

    public String inputAddress(Scanner scanner) {
        System.out.println("Nhập vào địa chỉ sinh viên:");
        do {
            String address = scanner.nextLine();
            if (address.trim().length() == 0) {
                System.err.println("Chưa nhập địa chỉ, vui lòng nhập lại");
            } else {
                return address;
            }
        } while (true);
    }

    public String inputPhone(Scanner scanner) {
        System.out.println("Nhập vào số điện thoại của sinh viên:");
        do {
            String phone = scanner.nextLine();
            if (phone.charAt(0) == '0') {
                if (phone.length() == 10) {
                    boolean isExist = false;
                    for (int i = 0; i < StudentManagement.currentIndex; i++) {
                        if (StudentManagement.arrStudents[i].getPhone().equals(phone)) {
                            isExist = true;
                            break;
                        }
                    }

                    if (isExist) {
                        System.err.println("Số điện thoại đã được đăng ký, vui lòng nhập lại");
                    } else {
                        return phone;
                    }
                } else {
                    System.err.println("Số điện thoại có 10 ký tự, vui lòng nhập lại");
                }
            } else {
                System.err.println("Số điện thoại phải bắt đầu là 0, vui lòng nhập lại");
            }
        } while (true);
    }

    public void displayData() {
        System.out.printf("Mã SV: %s - Tên SV: %s - Tuổi: %d - Giới tính: %s\n",
                this.studentId, this.studentName, this.age, this.sex ? "Nam" : "Nữ");
        System.out.printf("Địa chỉ: %s - Số điện thoại: %s\n", this.address, this.phone);
    }
}
