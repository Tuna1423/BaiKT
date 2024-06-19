package com.example.Tuan.BaiKT.service;


import com.example.Tuan.BaiKT.models.NhanVien;
import com.example.Tuan.BaiKT.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NhanVienService {

    private final NhanVienRepository nhanVienRepository;

    @Autowired
    public NhanVienService(NhanVienRepository nhanVienRepository) {
        this.nhanVienRepository = nhanVienRepository;
    }

    public Page<NhanVien> findPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return nhanVienRepository.findAll(pageable);
    }
}

