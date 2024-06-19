package com.example.Tuan.BaiKT.models;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PhongBan")
public class PhongBan {

    @Id
    @Column(name = "Ma_Phong", length = 2, nullable = false)
    private String maPhong;

    @Column(name = "Ten_Phong", length = 30, nullable = false)
    private String tenPhong;

    @OneToMany(mappedBy = "phongBan")
    private Set<NhanVien> nhanViens;
}