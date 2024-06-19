package com.example.Tuan.BaiKT.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NhanVien")
public class NhanVien {

    @Id
    @Column(name = "Ma_NV", length = 3, nullable = false)
    private String maNV;

    @Column(name = "Ten_NV", length = 100, nullable = false)
    private String tenNV;

    @Column(name = "Phai", length = 3)
    private String phai;

    @Column(name = "Noi_Sinh", length = 200)
    private String noiSinh;

    @Column(name = "Luong")
    private int luong;

    @ManyToOne
    @JoinColumn(name = "Ma_Phong", nullable = false)
    private PhongBan phongBan;
}
