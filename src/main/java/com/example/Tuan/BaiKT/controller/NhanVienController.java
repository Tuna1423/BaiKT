package com.example.Tuan.BaiKT.controller;


import com.example.Tuan.BaiKT.models.NhanVien;
import com.example.Tuan.BaiKT.models.PhongBan;
import com.example.Tuan.BaiKT.repository.NhanVienRepository;
import com.example.Tuan.BaiKT.repository.PhongBanRepository;
import com.example.Tuan.BaiKT.service.NhanVienService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nhanvien")
public class NhanVienController {
    private final NhanVienRepository nhanvienRepository;
    private final PhongBanRepository phongbanRepository;
    private final NhanVienService nhanVienService;

    public NhanVienController(NhanVienRepository nhanvienRepository, PhongBanRepository phongbanRepository, NhanVienService nhanVienService) {
        this.nhanvienRepository = nhanvienRepository;
        this.phongbanRepository = phongbanRepository;
        this.nhanVienService = nhanVienService;
    }

    @GetMapping
    public String showNhanVienList(@RequestParam(defaultValue = "0") int page, Model model) {
        Page<NhanVien> nhanVienPage = nhanVienService.findPaginated(page, 5);
        model.addAttribute("nhanViens", nhanVienPage);
        model.addAttribute("currentPage", page);
        return "nhanvien/nhanvien_list";
    }

    @GetMapping("/add")
    public String addNhanVienForm(Model model) {
        model.addAttribute("nhanVien", new NhanVien());
        List<PhongBan> phongBans = phongbanRepository.findAll();
        model.addAttribute("phongBans", phongBans);
        return "nhanvien/add-nhanvien";
    }

    @PostMapping("/add")
    public String addNhanVien(@ModelAttribute NhanVien nhanVien) {
        nhanvienRepository.save(nhanVien);
        return "redirect:/nhanvien";
    }

    @GetMapping("/edit/{maNV}")
    public String editNhanVienForm(@PathVariable String maNV, Model model) {
        NhanVien nhanVien = nhanvienRepository.findById(maNV)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + maNV));
        model.addAttribute("nhanVien", nhanVien);
        List<PhongBan> phongBans = phongbanRepository.findAll();
        model.addAttribute("phongBans", phongBans);
        return "nhanvien/edit-nhanvien";
    }

    @PostMapping("/edit/{maNV}")
    public String editNhanVien(@PathVariable String maNV, @ModelAttribute NhanVien nhanVien) {
        nhanvienRepository.save(nhanVien);
        return "redirect:/nhanvien";
    }

    @GetMapping("/delete/{maNV}")
    public String deleteNhanVien(@PathVariable String maNV) {
        nhanvienRepository.deleteById(maNV);
        return "redirect:/nhanvien";
    }
}

