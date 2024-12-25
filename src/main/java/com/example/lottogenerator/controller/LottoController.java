package com.example.lottogenerator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class LottoController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/generate")
    public String generateLottoNumbers(Model model) {
        // 1~45 사이의 랜덤 숫자 6개 생성
        List<Integer> lottoNumbers = new Random()
                .ints(1, 46)
                .distinct()
                .limit(6)
                .sorted()
                .boxed()
                .collect(Collectors.toList());

        model.addAttribute("lottoNumbers", lottoNumbers);
        return "index";
    }
}
