CREATE DATABASE Polypro;

USE Polypro;

CREATE TABLE NhanVien(
MaNV nvarchar(50) NOT NULL,
MatKhau nvarchar(50) NOT NULL,
HoTen nvarchar(50) NOT NULL,
VaiTro bit NOT NULL DEFAULT 0,
PRIMARY KEY(MaNV)
);

CREATE TABLE ChuyenDe(
MaCD nvarchar(15) NOT NULL,
TenCD nvarchar(50) NOT NULL,
HocPhi float NOT NULL DEFAULT 0,
ThoiLuong int NOT NULL DEFAULT 30,
Hinh nvarchar(50),
MoTa nvarchar(255) NOT NULL,
PRIMARY KEY(MaCD),
UNIQUE(TenCD),
CHECK(HocPhi >= 0 AND ThoiLuong > 0)
);

CREATE TABLE NguoiHoc(
MaNH nchar(7) NOT NULL,
HoTen nvarchar(50) NOT NULL,
NgaySinh date NOT NULL,
GioiTinh bit NOT NULL DEFAULT 0,
DienThoai nvarchar(50) NOT NULL,
Email nvarchar(50) NOT NULL,
GhiChu text NULL,
MaNV nvarchar(50) NOT NULL,
NgayDK date NOT NULL,
PRIMARY KEY(MaNH),
FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV) ON UPDATE CASCADE
);

CREATE TABLE KhoaHoc(
MaKH int auto_increment NOT NULL,
MaCD nvarchar(15) NOT NULL,
HocPhi float NOT NULL DEFAULT 0,
ThoiLuong int NOT NULL DEFAULT 0,
NgayKG date NOT NULL,
GhiChu nvarchar(50) NULL,
MaNV nvarchar(50) NOT NULL,
NgayTao date NOT NULL,
PRIMARY KEY(MaKH),
CHECK(HocPhi >= 0 AND ThoiLuong > 0),
FOREIGN KEY (MaCD) REFERENCES ChuyenDe(MaCD) ON UPDATE CASCADE,
FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV) ON UPDATE CASCADE
);

CREATE TABLE HocVien(
MaHV int auto_increment NOT NULL,
MaKH int NOT NULL,
MaNH nchar(7) NOT NULL,
Diem float NOT NULL,
PRIMARY KEY(MaHV),
UNIQUE(MaKH, MaNH),
FOREIGN KEY (MaKH) REFERENCES KhoaHoc(MaKH) ON DELETE CASCADE,
FOREIGN KEY (MaNH) REFERENCES NguoiHoc(MaNH) ON UPDATE CASCADE
);

select nguoihoc.manh,hoten,gioitinh,ngaysinh,dienthoai,email from nguoihoc inner join hocvien on nguoihoc.manh = hocvien.manh
                              inner join khoahoc on hocvien.makh = khoahoc.makh
                    where khoahoc.makh != '1';

Insert into NhanVien
values("TP01","123tp","Đạt 1",0),
        ("NV01","123nv","Đạt 2",1),
        ("TP02","1234","Đạt 3",0),
        ("NV02","1234","Đạt 4",0),
        ("NV03","12345","Đạt 5",0);
      
Insert into ChuyenDe
values("CD01","Lập trình cơ bản với C/C++",250000,20,"/Users/nguyenvandat/Desktop/Img/C.jpeg","Lập trình cơ bản với C/C++"),
        ("CD02","Lập trình Java",300000,25,"/Users/nguyenvandat/Desktop/Img/Java.png","Lập trình Java"),
      ("CD03","Lập trình C#",280000,25,"/Users/nguyenvandat/Desktop/Img/C\#.png","Lập trình C#"),
        ("CD04","Lập trình Python",300000,25,"/Users/nguyenvandat/Desktop/Img/python.jpg","Lập trình Python"),
      ("CD05","HTML5/CSS3",200000,10,"/Users/nguyenvandat/Desktop/Img/html5-css3.png","HTML5/CSS3");
      
Insert into KhoaHoc (MaCD,HocPhi,ThoiLuong,NgayKG,GhiChu,MaNV,NgayTao)
values("CD01",250000,20,"2019-01-01","Lập trình C/C++","NV01","2018-12-12"),
        ("CD01",250000,20,"2020-01-01","Lập trình C/C++","NV02","2019-12-12"),
      ("CD02",300000,25,"2019-02-02","Lập trình Java","TP01","2018-12-8"),
        ("CD02",300000,25,"2020-03-04","Lập trình Java","TP02","2020-01-02"),
      ("CD03",280000,25,"2019-05-28","Lập trình C#","NV01","2019-05-25"),
        ("CD03",280000,25,"2020-01-01","Lập trình C#","NV02","2019-12-12"),
      ("CD04",300000,20,"2019-01-01","Lập trình Python","NV02","2018-12-12"),
        ("CD04",300000,20,"2020-01-01","Lập trình Python","NV03","2019-12-12"),
      ("CD05",200000,10,"2019-01-29","HTML5/CSS3","TP01","2018-12-12"),
        ("CD05",200000,10,"2020-02-28","HTML5/CSS3","TP01","2019-08-12");
      
Insert into NguoiHoc
Values("NH01","Nguyễn Văn A","2001-08-29",1,"0364014254","datnguyen29@gmail.com","Sinh viên","NV01","2020-01-01"),
        ("NH02","Nguyễn Văn B","2001-10-15",1,"0364019999","datnguyen15@gmail.com","Sinh viên","NV02","2020-01-02"),
      ("NH03","Lê Thị C","2001-11-17",0,"0369102939","phuongnt1711@gmail.com","Sinh viên","NV03","2020-01-03"),
      ("NH04","Nguyễn Văn D","2001-06-29",1,"0129381283","abc@gmail.com","Sinh viên","NV01","2020-03-01"),
      ("NH05","Nguyễn Thị E","2000-08-29",0,"0364014259","dce@gmail.com","Sinh viên","NV01","2020-02-01"),
      ("NH06","Trịnh Thị C","2002-01-17",1,"0368102939","anh29@gmail.com","Sinh viên","NV03","2020-01-09"),
      ("NH07","Lê Thị D","2001-09-29",0,"0129383283","love29@gmail.com","Sinh viên","NV01","2020-03-20"),
      ("NH08","Nguyễn Văn E","2003-08-29",1,"0364044254","abc2910@gmail.com","Sinh viên","NV01","2020-03-01");

Insert into HocVien(MaKH,MaNH,Diem)
values(1,"NH01",10),
        (2,"NH02",9),
      (3,"NH03",8),
      (4,"NH04",8.5),
      (5,"NH05",9),
      (6,"NH06",7),
        (7,"NH07",9),
      (8,"NH08",9.5);

drop PROCEDURE sp_thongkenguoihoc
DELIMITER $$
CREATE PROCEDURE sp_thongkenguoihoc()
BEGIN
      SELECT
      YEAR(NgayDK) Nam,
      COUNT(*) SoLuong,
      MIN(NgayDK) DauTien,
      MAX(NgayDK) CuoiCung
      FROM NguoiHoc
      GROUP BY YEAR(NgayDK);
END; $$
call sp_thongkenguoihoc

drop PROCEDURE sp_ThongKeDoanhThu
DELIMITER $$
CREATE PROCEDURE sp_ThongKeDoanhThu(in Nam int)
BEGIN
SELECT
TenCD ChuyenDe,
COUNT(DISTINCT kh.MaKH) SoKH,
COUNT(hv.MaHV) SoHV,
SUM(kh.HocPhi) DoanhThu,
MIN(kh.HocPhi) ThapNhat,
MAX(kh.HocPhi) CaoNhat,
AVG(kh.HocPhi) TrungBinh
FROM KhoaHoc kh
JOIN HocVien hv ON kh.MaKH=hv.MaKH
JOIN ChuyenDe cd ON cd.MaCD=kh.MaCD
WHERE YEAR(NgayKG) = Nam
GROUP BY TenCD;
END; $$

drop PROCEDURE sp_ThongKeDiem
DELIMITER $$
CREATE PROCEDURE sp_ThongKeDiem()
BEGIN
SELECT
TenCD ChuyenDe,
COUNT(MaHV) SoHV,
MIN(Diem) ThapNhat,
MAX(Diem) CaoNhat,
AVG(Diem) TrungBinh
FROM KhoaHoc kh
JOIN HocVien hv ON kh.MaKH=hv.MaKH
JOIN ChuyenDe cd ON cd.MaCD=kh.MaCD
GROUP BY TenCD;
END $$

drop PROCEDURE sp_BangDiem
DELIMITER $$
CREATE PROCEDURE sp_BangDiem(in MaKH INT)
BEGIN
SELECT
nh.MaNH,
nh.HoTen,
hv.Diem
FROM HocVien hv
JOIN NguoiHoc nh ON nh.MaNH=hv.MaNH
WHERE hv.MaKH = MaKH
ORDER BY hv.Diem DESC;
END $$
