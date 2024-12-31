package com.example.lottogenerator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
        // 1부터 45까지의 숫자 리스트 생성
        List<Integer> allNumbers = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());

        // 리스트를 섞어서 상위 6개 숫자 선택
        Collections.shuffle(allNumbers);
        List<Integer> lottoNumbers = new ArrayList<>(allNumbers.subList(0, 6));

        // 번호를 오름차순으로 정렬
        Collections.sort(lottoNumbers);

        // 디버깅용 로그 출력
        System.out.println("Generated Lotto Numbers: " + lottoNumbers);

        // 모델에 생성된 로또 번호 추가
        model.addAttribute("lottoNumbers", lottoNumbers);

        return "index";
    }
}
