package com.example.projectsoftuni.web;

import com.example.projectsoftuni.model.binding.HensAddBindingModel;
import com.example.projectsoftuni.model.view.UserViewModel;
import com.example.projectsoftuni.repository.HensAddRepository;
import com.example.projectsoftuni.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class HomeController {

    private final EggAddService eggAddService;
    private final HensAddService hensAddService;
    private final ModelMapper modelMapper;
    private final HensAddBindingModel hensAddBindingModel;
    private final HensAddRepository hensAddRepository;
    private final CartonAddService cartonAddService;
    private final UserService userService;
    private final UserViewModel userViewModel;
    private final ResidueOfExtractionService residueOfExtractionService;

    public HomeController(EggAddService eggAddService, HensAddService hensAddService
            , ModelMapper modelMapper, HensAddBindingModel hensAddBindingModel
            , HensAddRepository hensAddRepository, CartonAddService cartonAddService, UserService userService, UserViewModel userViewModel, ResidueOfExtractionService residueOfExtractionService) {

        this.eggAddService = eggAddService;
        this.hensAddService = hensAddService;
        this.modelMapper = modelMapper;
        this.hensAddBindingModel = hensAddBindingModel;
        this.hensAddRepository = hensAddRepository;
        this.cartonAddService = cartonAddService;
        this.userService = userService;
        this.userViewModel = userViewModel;
        this.residueOfExtractionService = residueOfExtractionService;
    }

    @GetMapping("/")
    public String index(){

        return "index";

    }



    @GetMapping("/home")
    public String home(){

        return "home";

    }

    @GetMapping("/allCountTableByCategory")
    public String AllCountTable(Model model){

        //Base Lower
        //XL
        model.addAttribute("eggXLCoreyLower", eggAddService.findByCategoryXLLower() / 20);
        model.addAttribute("eggXLCartonLower", eggAddService.findByCategoryXLCartonsLower() / 120);
        //L
        model.addAttribute("eggFamilyCoreyLowerL", eggAddService.findCoreyFamilyBaseLowerL() / 30);
        model.addAttribute("eggChezCoreyLowerL", eggAddService.findCoreyChezBaseLowerL() / 30);
        model.addAttribute("eggEuroCoreyLowerL", eggAddService.findCoreyEuroBaseLowerL() / 30);
        model.addAttribute("eggHartmanCoreyLowerL", eggAddService.findCoreyHartmanBaseLowerL() / 30);
        model.addAttribute("eggLCartonLower", eggAddService.findByCategoryLCartonLower() / 180);
        model.addAttribute("eggLCartonLowerBrown", eggAddService.findCartons180BaseLowerBrownL() / 180);
        model.addAttribute("eggLCartonLowerBrown360", eggAddService.findCartons360BaseLowerBrownL() / 360);
        model.addAttribute("eggLCoreyUkraynaLowerL", eggAddService.findCoreyUkraynaLowerL() / 30);
        model.addAttribute("eggLCoreyElpaLowerL", eggAddService.findCoreyElpaLowerL() / 30);
        model.addAttribute("eggLCoreyEkoFarmLowerL", eggAddService.findCoreyEkoFarmLowerL() / 30);
        model.addAttribute("eggLCoreyNew1LowerL", eggAddService.findCoreyNew1LowerL() / 30);
        model.addAttribute("eggLCoreyNew2LowerL", eggAddService.findCoreyNew2LowerL() / 30);

        //M
        model.addAttribute("eggMCartonLower", eggAddService.findByCategoryMCartonLower() / 180);
        model.addAttribute("eggFamilyCoreyLowerM", eggAddService.findCoreyFamilyBaseLowerM() / 30);
        model.addAttribute("eggChezCoreyLowerM", eggAddService.findCoreyChezBaseLowerM() / 30);
        model.addAttribute("eggEuroCoreyLowerM", eggAddService.findCoreyEuroBaseLowerM() / 30);
        model.addAttribute("eggHartmanCoreyLowerM", eggAddService.findCoreyHartmanBaseLowerM() / 30);
        model.addAttribute("eggLCartonMowerBrown", eggAddService.findByCarton180BaseLowerBrownM() / 180);
        model.addAttribute("eggLCartonMowerBrown360", eggAddService.findByCarton360BaseLowerBrownM() / 360);
        model.addAttribute("eggCoreyUkraynaLowerM", eggAddService.findCoreyUkraynaLowerM() / 30);
        model.addAttribute("eggCoreyElpaLowerM", eggAddService.findCoreyElpaLowerM() / 30);
        model.addAttribute("eggCoreyEkoFarmLowerM", eggAddService.findCoreyEkoFarmLowerM() / 30);
        model.addAttribute("eggCoreyNew1LowerM", eggAddService.findCoreyNew1LowerM() / 30);
        model.addAttribute("eggCoreyNew2LowerM", eggAddService.findCoreyNew2LowerM() / 30);

        //S
        model.addAttribute("eggSCartonLower", eggAddService.findByCategorySCartonLower() / 180);
        model.addAttribute("eggFamilyCoreyLowerS", eggAddService.findCoreyFamilyBaseLowerS() / 30);
        model.addAttribute("eggChezCoreyLowerS", eggAddService.findCoreyChezBaseLowerS() / 30);
        model.addAttribute("eggEuroCoreyLowerS", eggAddService.findCoreyEuroBaseLowerS() / 30);
        model.addAttribute("eggHartmanCoreyLowerS", eggAddService.findCoreyHartmanBaseLowerS() / 30);
        model.addAttribute("eggSCartonMowerBrown", eggAddService.findCarton180BaseLowerBrownS() / 180);
        model.addAttribute("eggSCartonMowerBrown360", eggAddService.findCarton360BaseLowerBrownS()/ 360);
        model.addAttribute("eggCoreyUkraynaLowerS", eggAddService.findCoreyUkraynaLowerS() / 30);
        model.addAttribute("eggCoreyElpaLowerS", eggAddService.findCoreyElpaLowerS() / 30);
        model.addAttribute("eggCoreyEkoFarmLowerS", eggAddService.findCoreyEkoFarmLowerS() / 30);
        model.addAttribute("eggCoreyNew1LowerS", eggAddService.findCoreyNew1LowerS() / 30);
        model.addAttribute("eggCoreyNew2LowerS", eggAddService.findCoreyNew2LowerS() / 30);

        //Broken
        model.addAttribute("eggBrokenCartonLower", eggAddService.findByCartonLowerBroken() / 180);
        model.addAttribute("eggFamilyCoreyLowerBr", eggAddService.findCoreyFamilyLowerBroken() / 30);
        model.addAttribute("eggChezCoreyLowerBr", eggAddService.findCoreyChezLowerBroken() / 30);
        model.addAttribute("eggEuroCoreyLowerBr", eggAddService.findCoreyEuroLowerBroken() / 30);
        model.addAttribute("eggHartmanCoreyLowerBr", eggAddService.findCoreyHartmanLowerBroken() / 30);
        model.addAttribute("eggBrCartonMowerBrown", eggAddService.findCarton180BaseLowerBrownBroken() / 180);
        model.addAttribute("eggBrCartonMowerBrown360", eggAddService.findCarton360BaseLowerBrownBroken()/ 360);
        model.addAttribute("eggCoreyUkraynaLowerBROKEN", eggAddService.findCoreyUkraynaLowerBROKEN() / 30);
        model.addAttribute("eggCoreyElpaLowerBROKEN", eggAddService.findCoreyElpaLowerBROKEN() / 30);
        model.addAttribute("eggCoreyEkoFarmLowerBROKEN", eggAddService.findCoreyEkoFarmLowerBROKEN() / 30);
        model.addAttribute("eggCoreyNew1LowerBROKEN", eggAddService.findCoreyNew1LowerBROKEN() / 30);
        model.addAttribute("eggCoreyNew2LowerBROKEN", eggAddService.findCoreyNew2LowerBROKEN() / 30);


        //Base Upper
        //XL
        model.addAttribute("eggXLCoreyUpper", eggAddService.findByCategoryXLUpper() / 20);
        model.addAttribute("eggXLCartonUpper", eggAddService.findByCategoryXLCartonsUpper() / 120);
        //L
        model.addAttribute("eggFamilyCoreyUpperL", eggAddService.findCoreyFamilyUpperL() / 30);
        model.addAttribute("eggChezCoreyUpperL", eggAddService.findCoreyChezUpperL() / 30);
        model.addAttribute("eggEuroCoreyUpperL", eggAddService.findCoreyEuroUpperL() / 30);
        model.addAttribute("eggHartmanCoreyUpperL", eggAddService.findCoreyHartmanUpperL() / 30);
        model.addAttribute("eggLCartonUpper", eggAddService.findByCategoryLCartonsUpper() / 180);
        model.addAttribute("eggLCartonUpperBrown", eggAddService.findCarton180UpperBrownL() / 180);
        model.addAttribute("eggLCartonUpperBrown360", eggAddService.findCarton360UpperBrownL() / 360);
        model.addAttribute("eggCoreyUkraynaUpperL", eggAddService.findCoreyUkraynaUpperL() / 30);
        model.addAttribute("eggCoreyElpaUpperL", eggAddService.findCoreyElpaUpperL() / 30);
        model.addAttribute("eggCoreyEkoFarmUpperL", eggAddService.findCoreyEkoFarmUpperL() / 30);
        model.addAttribute("eggCoreyNew1UpperL", eggAddService.findCoreyNew1UpperL() / 30);
        model.addAttribute("eggCoreyNew2UpperL", eggAddService.findCoreyNew2UpperL() / 30);


        //M
        model.addAttribute("eggFamilyCoreyUpperM", eggAddService.findCoreyFamilyUpperM() / 30);
        model.addAttribute("eggChezCoreyUpperM", eggAddService.findCoreyChezUpperM() / 30);
        model.addAttribute("eggEuroCoreyUpperM", eggAddService.findCoreyEuroUpperM() / 30);
        model.addAttribute("eggHartmanCoreyUpperM", eggAddService.findCoreyHartmanUpperM() / 30);
        model.addAttribute("eggMCartonUpper", eggAddService.findByCategoryMCartonsUpper() / 180);
        model.addAttribute("eggMCartonUpperBrown", eggAddService.findCarton180UpperBrownM() / 180);
        model.addAttribute("eggMCartonUpperBrown360", eggAddService.findCarton360UpperBrownM() / 360);
        model.addAttribute("eggCoreyUkraynaUpperM", eggAddService.findCoreyUkraynaUpperM() / 30);
        model.addAttribute("eggCoreyElpaUpperM", eggAddService.findCoreyElpaUpperM() / 30);
        model.addAttribute("eggCoreyEkoFarmUpperM", eggAddService.findCoreyEkoFarmUpperM() / 30);
        model.addAttribute("eggCoreyNew1UpperM", eggAddService.findCoreyNew1UpperM() / 30);
        model.addAttribute("eggCoreyNew2UpperM", eggAddService.findCoreyNew2UpperM() / 30);

        //S
        model.addAttribute("eggFamilyCoreyUpperS", eggAddService.findCoreyFamilyUpperS() / 30);
        model.addAttribute("eggChezCoreyUpperS", eggAddService.findCoreyChezUpperS() / 30);
        model.addAttribute("eggEuroCoreyUpperS", eggAddService.findCoreyEuroUpperS() / 30);
        model.addAttribute("eggHartmanCoreyUpperS", eggAddService.findCoreyHartmanUpperS() / 30);
        model.addAttribute("eggSCartonUpper", eggAddService.findByCategorySCartonUpper() / 180);
        model.addAttribute("eggSCartonUpperBrown", eggAddService.findCarton180UpperBrownS() / 180);
        model.addAttribute("eggSCartonUpperBrown360", eggAddService.findCarton360UpperBrownS() / 360);
        model.addAttribute("eggCoreyUkraynaUpperS", eggAddService.findCoreyUkraynaUpperS() / 30);
        model.addAttribute("eggCoreyElpaUpperS", eggAddService.findCoreyElpaUpperS() / 30);
        model.addAttribute("eggCoreyEkoFarmUpperS", eggAddService.findCoreyEkoFarmUpperS() / 30);
        model.addAttribute("eggCoreyNew1UpperS", eggAddService.findCoreyNew1UpperS() / 30);
        model.addAttribute("eggCoreyNew2UpperS", eggAddService.findCoreyNew2UpperS() / 30);

        //Broken
        model.addAttribute("eggBrokenCartonUpper", eggAddService.findCartonUpperBroken() / 180);
        model.addAttribute("eggFamilyCoreyUpperBr", eggAddService.findCoreyFamilyUpperBroken() / 30);
        model.addAttribute("eggChezCoreyUpperBr", eggAddService.findCoreyChezUpperBroken() / 30);
        model.addAttribute("eggEuroCoreyUpperBr", eggAddService.findCoreyEuroUpperBroken() / 30);
        model.addAttribute("eggHartmanCoreyUpperBr", eggAddService.findCoreyHartmanUpperBroken() / 30);
        model.addAttribute("eggBrCartonUpperBrown", eggAddService.findCarton180BaseUpperBrownBroken() / 180);
        model.addAttribute("eggBrCartonUpperBrown360", eggAddService.findCarton360BaseUpperBrownBroken()/ 360);
        model.addAttribute("eggCoreyUkraynaUpperBROKEN", eggAddService.findCoreyUkraynaUpperBROKEN() / 30);
        model.addAttribute("eggCoreyElpaUpperBROKEN", eggAddService.findCoreyElpaUpperBROKEN() / 30);
        model.addAttribute("eggCoreyEkoFarmUpperBROKEN", eggAddService.findCoreyEkoFarmUpperBROKEN() / 30);
        model.addAttribute("eggCoreyNew1UpperBROKEN", eggAddService.findCoreyNew1UpperBROKEN() / 30);
        model.addAttribute("eggCoreyNew2UpperBROKEN", eggAddService.findCoreyNew2UpperBROKEN() / 30);


        // ???? ???????? ???????? ???? ?????????????????? ???? ???????????? ???? ???????? 1 + 2

     //   model.addAttribute("countXL", eggAddService.findByCategoryXL());
     //   model.addAttribute("countL", eggAddService.findByCategoryL());
     //   model.addAttribute("countM", eggAddService.findByCategoryM());
     //   model.addAttribute("countS", eggAddService.findByCategoryS());
     //   model.addAttribute("countBROKEN", eggAddService.findByCategoryBROKEN());
//
//
     //   model.addAttribute("countXLCarton", eggAddService.findByCategoryXL() / 120);
     //   model.addAttribute("countLCarton", eggAddService.findByCategoryL() / 180);
     //   model.addAttribute("countMCarton", eggAddService.findByCategoryM() / 180);
     //   model.addAttribute("countSCarton", eggAddService.findByCategoryS() / 180);
     //   model.addAttribute("countBROKENCarton", eggAddService.findByCategoryBROKEN() / 180);


        return "allCountTableByCategory";
    }

    @GetMapping("/count-hens-now")
    public String countHensNow(Model model){

        model.addAttribute("countFIRST", hensAddService.getCountOfHnesFirstLast());
        model.addAttribute("countSECOND", hensAddService.getCountOfHensSecondLast());
        model.addAttribute("countTHIRD", hensAddService.getCountOfHensThirdLast());
        model.addAttribute("countFOURTH", hensAddService.getCountOfHensFourthLast());
        model.addAttribute("countFIFTH", hensAddService.getCountOfHensFifthLast());
        model.addAttribute("countSIXTH", hensAddService.getCountOfHensSixthLast());
        model.addAttribute("countSEVENTH", hensAddService.getCountOfHensSeventhLast());
        model.addAttribute("countEIGHT", hensAddService.getCountOfHensEighthLast());
        model.addAttribute("countNINTH", hensAddService.getCountOfHensNinthLast());

        return "count-hens-now";
    }

    @GetMapping("/count-cartons-now")
    public String allCartonsCount(Model model){

        //Upper Base
        model.addAttribute("countCorey120Upper",cartonAddService.getCountOfCore120FromBaseUpper());
        model.addAttribute("countCarton120Upper", cartonAddService.getCountOfCarton120FromBaseUpper());
        model.addAttribute("countCarton180Upper", cartonAddService.getCountOfCarton180FromBaseUpper());
        model.addAttribute("countCoreyFamilyUpper", cartonAddService.getCountCoreyFamilyUpper());
        model.addAttribute("countCoreyChezUpper", cartonAddService.getCountCoreyChezUpper());
        model.addAttribute("countCoreyHartmanUpper", cartonAddService.getCountCoreyHartmanUpper());
        model.addAttribute("countCoreyEuroUpper", cartonAddService.getCountCoreyEuroUpper());
        model.addAttribute("countCarton180BrownUpper", cartonAddService.getCountOfCarton180FromBaseUpperBrown());
        model.addAttribute("countCarton360BrownUpper", cartonAddService.getCountOfCarton360FromBaseUpperBrown());
        model.addAttribute("countPaperDunapackUpper", cartonAddService.getCountPaperDunapackUpper());
        model.addAttribute("countPaperDSmitkUpper", cartonAddService.getCountPaperDSmitkUpper());
        model.addAttribute("countCornerDunapackUpper", cartonAddService.getCountCornerDunapackUpper());
        model.addAttribute("countCornerDSmitkUpper", cartonAddService.getCountCornerDSmitkUpper());
        model.addAttribute("countCoreyUkraynaUpper", cartonAddService.getCountCoreyUkraynaUpper());
        model.addAttribute("countCoreyElpaUpper", cartonAddService.getCountCoreyElpaUpper());
        model.addAttribute("countCoreyEkoFarmUpper", cartonAddService.getCountCoreyEkoFarmUpper());
        model.addAttribute("countCoreyNew1Upper", cartonAddService.getCountCoreyNew1Upper());
        model.addAttribute("countCoreyNew2Upper", cartonAddService.getCountCoreyNew2Upper());


        //Lower Base
        model.addAttribute("countCorey20Lower",cartonAddService.getCountOfCore120FromBaseLower());
        model.addAttribute("countCarton120Lower", cartonAddService.getCountOfCarton120FromBaseLower());
        model.addAttribute("countCarton180Lower", cartonAddService.getCountOfCarton180FromBaseLower());
        model.addAttribute("countCoreyFamilyLower", cartonAddService.getCountCoreyFamilyLower());
        model.addAttribute("countCoreyChezLower", cartonAddService.getCountCoreyChezLower());
        model.addAttribute("countCoreyHartmanLower", cartonAddService.getCountCoreyHartmanLower());
        model.addAttribute("countCoreyEuroLower", cartonAddService.getCountCoreyEuroLower());
        model.addAttribute("countCarton180BrownLower", cartonAddService.getCountOfCarton180FromBaseLowerBrown());
        model.addAttribute("countCarton360BrownLower", cartonAddService.getCountOfCarton360FromBaseLowerBrown());
        model.addAttribute("countPaperDunapackLower", cartonAddService.getCountPaperDunapackLower());
        model.addAttribute("countPaperDSmitkLower", cartonAddService.getCountPaperDSmitkLower());
        model.addAttribute("countCornerDunapackLower", cartonAddService.getCountCornerDunapackLower());
        model.addAttribute("countCornerDSmitkLower", cartonAddService.getCountCornerDSmitkLower());
        model.addAttribute("countCoreyUkraynaLower", cartonAddService.getCountCoreyUkraynaLower());
        model.addAttribute("countCoreyElpaLower", cartonAddService.getCountCoreyElpaLower());
        model.addAttribute("countCoreyEkoFarmLower", cartonAddService.getCountCoreyEkoFarmLower());
        model.addAttribute("countCoreyNew1Lower", cartonAddService.getCountCoreyNew1Lower());
        model.addAttribute("countCoreyNew2Lower", cartonAddService.getCountCoreyNew2Lower());


        return "count-cartons-now";
    }

    @GetMapping("/percentage-table")
    public String percentage(Model model){

        //???? ???????? ???? ???????????? ???? ?????????? ???????? ???? ?????????????? ??????
        Long countEggOfFirstHaleByDescDateCurrentDay
                = eggAddService.findByHaleFirstAndDateDescCurrentDay();

        Long countHensOfFirstHaleByDescDateCurrentDay
                = hensAddService.getCountOfHensFirstAboutCurrentDay();

        float percentHaleFirstCurrentDay
                = (countEggOfFirstHaleByDescDateCurrentDay / (countHensOfFirstHaleByDescDateCurrentDay * 1.0f)) * 100;

        model.addAttribute("currentDay", LocalDate.now());
        model.addAttribute("countEggOfFirstHaleByDescDate"
                , String.format("%.2f",percentHaleFirstCurrentDay));

        //???? ?????????????? ?????? - 1 ??????
        Long countEggOfFirstHaleByDescDateCurrentDayMinusOneDay
                = eggAddService.findFirstAndDateDescMinusOneDay();

        Long countHensOfFirstHaleByDescDateCurrentDayMinusOne
                = hensAddService.getCountOfHensFirstAboutCurrentDayMinusOne();

        float percentHaleFirstCurrentDayMinusOne
                = (countEggOfFirstHaleByDescDateCurrentDayMinusOneDay / (countHensOfFirstHaleByDescDateCurrentDayMinusOne * 1.0f)) * 100;

        model.addAttribute("currentDayMinusOne", LocalDate.now().minusDays(1));
        model.addAttribute("countEggOfFirstHaleByDescDateMinusOne"
                , String.format("%.2f",percentHaleFirstCurrentDayMinusOne));

        //???? ?????????????? ?????? - 2 ??????
        Long countEggOfFirstHaleByDescDateCurrentDayMinusTwoDay
                = eggAddService.findFirstAndDateDescMinusTwoDay();

        Long countHensOfFirstHaleByDescDateCurrentDayMinusTwo
                = hensAddService.getCountOfHensFirstAboutCurrentDayMinusTwo();

        float percentHaleFirstCurrentDayMinusTwo
                = (countEggOfFirstHaleByDescDateCurrentDayMinusTwoDay / (countHensOfFirstHaleByDescDateCurrentDayMinusTwo * 1.0f)) * 100;

        model.addAttribute("currentDayMinusTwo", LocalDate.now().minusDays(2));
        model.addAttribute("countEggOfFirstHaleByDescDateMinusTwo"
                , String.format("%.2f",percentHaleFirstCurrentDayMinusTwo));

        //???? ?????????????? ?????? - 3 ??????
        Long countEggOfFirstHaleByDescDateCurrentDayMinusThreeDay
                = eggAddService.findFirstAndDateDescMinusThreeDay();

        Long countHensOfFirstHaleByDescDateCurrentDayMinusThree
                = hensAddService.getCountOfHensFirstAboutCurrentDayMinusThree();

        float percentHaleFirstCurrentDayMinusThree
                = (countEggOfFirstHaleByDescDateCurrentDayMinusThreeDay/ (countHensOfFirstHaleByDescDateCurrentDayMinusThree
                * 1.0f)) * 100;

        model.addAttribute("currentDayMinusThree", LocalDate.now().minusDays(3));
        model.addAttribute("countEggOfFirstHaleByDescDateMinusThree"
                , String.format("%.2f",percentHaleFirstCurrentDayMinusThree));

        //???? ?????????????? ?????? - 4 ??????
        Long countEggOfFirstHaleByDescDateCurrentDayMinusFourthDay
                = eggAddService.findFirstAndDateDescMinusFourthDay();

        Long countHensOfFirstHaleByDescDateCurrentDayMinusFourth
                = hensAddService.getCountOfHensFirstAboutCurrentDayMinusFourth();

        float percentHaleFirstCurrentDayMinusFourth
                = (countEggOfFirstHaleByDescDateCurrentDayMinusFourthDay / (countHensOfFirstHaleByDescDateCurrentDayMinusFourth * 1.0f)) * 100;

        model.addAttribute("currentDayMinusFourth", LocalDate.now().minusDays(4));
        model.addAttribute("countEggOfFirstHaleByDescDateMinusFourth"
                , String.format("%.2f",percentHaleFirstCurrentDayMinusFourth));

        //???? ?????????????? ?????? - 5 ??????
        Long countEggOfFirstHaleByDescDateCurrentDayMinusFiveDay
                = eggAddService.findFirstAndDateDescMinusFiveDay();

        Long countHensOfFirstHaleByDescDateCurrentDayMinusFive
                = hensAddService.getCountOfHensFirstAboutCurrentDayMinusFive();

        float percentHaleFirstCurrentDayMinusFive
                = (countEggOfFirstHaleByDescDateCurrentDayMinusFiveDay / (countHensOfFirstHaleByDescDateCurrentDayMinusFive * 1.0f)) * 100;

        model.addAttribute("currentDayMinusFive", LocalDate.now().minusDays(5));
        model.addAttribute("countEggOfFirstHaleByDescDateMinusFive"
                , String.format("%.2f",percentHaleFirstCurrentDayMinusFive));

        //???? ?????????????? ?????? - 6 ??????
        Long countEggOfFirstHaleByDescDateCurrentDayMinusSixDay
                = eggAddService.findFirstAndDateDescMinusSixDay();

        Long countHensOfFirstHaleByDescDateCurrentDayMinusSix
                = hensAddService.getCountOfHensFirstAboutCurrentDayMinusSix();

        float percentHaleFirstCurrentDayMinusSix
                = (countEggOfFirstHaleByDescDateCurrentDayMinusSixDay / (countHensOfFirstHaleByDescDateCurrentDayMinusSix * 1.0f)) * 100;

        model.addAttribute("currentDayMinusSix", LocalDate.now().minusDays(6));
        model.addAttribute("countEggOfFirstHaleByDescDateMinusSix"
                , String.format("%.2f",percentHaleFirstCurrentDayMinusSix));

        //???? ?????????????? ?????? - 7 ??????
        Long countEggOfFirstHaleByDescDateCurrentDayMinusSevenDay
                = eggAddService.findFirstAndDateDescMinusSevenDay();

        Long countHensOfFirstHaleByDescDateCurrentDayMinusSeven
                = hensAddService.getCountOfHensFirstAboutCurrentDayMinusSeven();

        float percentHaleFirstCurrentDayMinusSeven
                = (countEggOfFirstHaleByDescDateCurrentDayMinusSevenDay / (countHensOfFirstHaleByDescDateCurrentDayMinusSeven * 1.0f)) * 100;

        model.addAttribute("currentDayMinusSeven", LocalDate.now().minusDays(7));
        model.addAttribute("countEggOfFirstHaleByDescDateMinusSeven"
                , String.format("%.2f",percentHaleFirstCurrentDayMinusSeven));


        //???? ???????? ???? ???????????? ???? ?????????? ???????? ???? ?????????????? ??????
        Long countEggOfSecondHaleByDescDateCurrentDay
                = eggAddService.findByHaleSecondAndDateDescCurrentDay();

        Long countHensOfSecondHaleByDescDateCurrentDay
                = hensAddService.getCountOfHensSecondAboutCurrentDay();

        float percentHaleSecondCurrentDay
                = (countEggOfSecondHaleByDescDateCurrentDay / (countHensOfSecondHaleByDescDateCurrentDay * 1.0f)) * 100;

        model.addAttribute("countEggOfSecondHaleByDescDate"
                , String.format("%.2f",percentHaleSecondCurrentDay));

        //???? ?????????????? ?????? - 1 ??????
        Long countEggOfSecondHaleByDescDateCurrentDayMinusOneDay
                = eggAddService.findSecondAndDateDescMinusOneDay();

        Long countHensOfSecondHaleByDescDateCurrentDayMinusOne
                = hensAddService.getCountOfHensSecondAboutCurrentDayMinusOne();

        float percentHaleSecondCurrentDayMinusOne
                = (countEggOfSecondHaleByDescDateCurrentDayMinusOneDay / (countHensOfSecondHaleByDescDateCurrentDayMinusOne * 1.0f)) * 100;

        model.addAttribute("countEggOfSecondHaleByDescDateMinusOne"
                , String.format("%.2f",percentHaleSecondCurrentDayMinusOne));

        //???? ?????????????? ?????? - 2 ??????
        Long countEggOfSecondHaleByDescDateCurrentDayMinusTwoDay
                = eggAddService.findSecondAndDateDescMinusTwoDay();

        Long countHensOfSecondHaleByDescDateCurrentDayMinusTwo
                = hensAddService.getCountOfHensSecondAboutCurrentDayMinusTwo();

        float percentHaleSecondCurrentDayMinusTwo
                = (countEggOfSecondHaleByDescDateCurrentDayMinusTwoDay / (countHensOfSecondHaleByDescDateCurrentDayMinusTwo * 1.0f)) * 100;

        model.addAttribute("countEggOfSecondHaleByDescDateMinusTwo"
                , String.format("%.2f",percentHaleSecondCurrentDayMinusTwo));

        //???? ?????????????? ?????? - 3 ??????
        Long countEggOfSecondHaleByDescDateCurrentDayMinusThreeDay
                = eggAddService.findSecondAndDateDescMinusThreeDay();

        Long countHensOfSecondHaleByDescDateCurrentDayMinusThree
                = hensAddService.getCountOfHensSecondAboutCurrentDayMinusThree();

        float percentHaleSecondCurrentDayMinusThree
                = (countEggOfSecondHaleByDescDateCurrentDayMinusThreeDay / (countHensOfSecondHaleByDescDateCurrentDayMinusThree
                * 1.0f)) * 100;

        model.addAttribute("countEggOfSecondHaleByDescDateMinusThree"
                , String.format("%.2f",percentHaleSecondCurrentDayMinusThree));

        //???? ?????????????? ?????? - 4 ??????
        Long countEggOfSecondHaleByDescDateCurrentDayMinusFourthDay
                = eggAddService.findSecondAndDateDescMinusFourthDay();

        Long countHensOfSecondHaleByDescDateCurrentDayMinusFourth
                = hensAddService.getCountOfHensSecondAboutCurrentDayMinusFourth();

        float percentHaleSecondCurrentDayMinusFourth
                = (countEggOfSecondHaleByDescDateCurrentDayMinusFourthDay/ (countHensOfSecondHaleByDescDateCurrentDayMinusFourth * 1.0f)) * 100;

        model.addAttribute("countEggOfSecondHaleByDescDateMinusFourth"
                , String.format("%.2f",percentHaleSecondCurrentDayMinusFourth));

        //???? ?????????????? ?????? - 5 ??????
        Long countEggOfSecondHaleByDescDateCurrentDayMinusFiveDay
                = eggAddService.findSecondAndDateDescMinusFiveDay();

        Long countHensOfSecondHaleByDescDateCurrentDayMinusFive
                = hensAddService.getCountOfHensSecondAboutCurrentDayMinusFive();

        float percentHaleSecondCurrentDayMinusFive
                = (countEggOfSecondHaleByDescDateCurrentDayMinusFiveDay / (countHensOfSecondHaleByDescDateCurrentDayMinusFive * 1.0f)) * 100;

        model.addAttribute("countEggOfSecondHaleByDescDateMinusFive"
                , String.format("%.2f",percentHaleSecondCurrentDayMinusFive));

        //???? ?????????????? ?????? - 6 ??????
        Long countEggOfSecondHaleByDescDateCurrentDayMinusSixDay
                = eggAddService.findSecondAndDateDescMinusSixDay();

        Long countHensOfSecondHaleByDescDateCurrentDayMinusSix
                = hensAddService.getCountOfHensSecondAboutCurrentDayMinusSix();

        float percentHaleSecondCurrentDayMinusSix
                = (countEggOfSecondHaleByDescDateCurrentDayMinusSixDay / (countHensOfSecondHaleByDescDateCurrentDayMinusSix * 1.0f)) * 100;

        model.addAttribute("countEggOfSecondHaleByDescDateMinusSix"
                , String.format("%.2f",percentHaleSecondCurrentDayMinusSix));

        //???? ?????????????? ?????? - 7 ??????
        Long countEggOfSecondHaleByDescDateCurrentDayMinusSevenDay
                = eggAddService.findSecondAndDateDescMinusSevenDay();

        Long countHensOfSecondHaleByDescDateCurrentDayMinusSeven
                = hensAddService.getCountOfHensSecondAboutCurrentDayMinusSeven();

        float percentHaleSecondCurrentDayMinusSeven
                = (countEggOfSecondHaleByDescDateCurrentDayMinusSevenDay / (countHensOfSecondHaleByDescDateCurrentDayMinusSeven * 1.0f)) * 100;

        model.addAttribute("countEggOfSecondHaleByDescDateMinusSeven"
                , String.format("%.2f",percentHaleSecondCurrentDayMinusSeven));


        //???? ???????? ???? ???????????? ???? ?????????? ???????? ???? ?????????????? ??????
        Long countEggOfThirdHaleByDescDateCurrentDay
                = eggAddService.findByHaleThirdAndDateDescCurrentDay();

        Long countHensOfThirdHaleByDescDateCurrentDay
                = hensAddService.getCountOfHensThirdAboutCurrentDay();

        float percentHaleThirdCurrentDay
                = (countEggOfThirdHaleByDescDateCurrentDay / (countHensOfThirdHaleByDescDateCurrentDay * 1.0f)) * 100;

        model.addAttribute("countEggOfThirdHaleByDescDate"
                , String.format("%.2f",percentHaleThirdCurrentDay));

        //???? ?????????????? ?????? - 1 ??????
        Long countEggOfThirdHaleByDescDateCurrentDayMinusOneDay
                = eggAddService.findThirdAndDateDescMinusOneDay();

        Long countHensOfThirdHaleByDescDateCurrentDayMinusOne
                = hensAddService.getCountOfHensThirdAboutCurrentDayMinusOne();

        float percentHaleThirdCurrentDayMinusOne
                = (countEggOfThirdHaleByDescDateCurrentDayMinusOneDay / (countHensOfThirdHaleByDescDateCurrentDayMinusOne * 1.0f)) * 100;

        model.addAttribute("countEggOfThirdHaleByDescDateMinusOne"
                , String.format("%.2f",percentHaleThirdCurrentDayMinusOne));

        //???? ?????????????? ?????? - 2 ??????
        Long countEggOfThirdHaleByDescDateCurrentDayMinusTwoDay
                = eggAddService.findThirdAndDateDescMinusTwoDay();

        Long countHensOfThirdHaleByDescDateCurrentDayMinusTwo
                = hensAddService.getCountOfHensThirdAboutCurrentDayMinusTwo();

        float percentHaleThirdCurrentDayMinusTwo
                = (countEggOfThirdHaleByDescDateCurrentDayMinusTwoDay / (countHensOfThirdHaleByDescDateCurrentDayMinusTwo * 1.0f)) * 100;

        model.addAttribute("countEggOfThirdHaleByDescDateMinusTwo"
                , String.format("%.2f",percentHaleThirdCurrentDayMinusTwo));

        //???? ?????????????? ?????? - 3 ??????
        Long countEggOfThirdHaleByDescDateCurrentDayMinusThreeDay
                = eggAddService.findThirdAndDateDescMinusThreeDay();

        Long countHensOfThirdHaleByDescDateCurrentDayMinusThree
                = hensAddService.getCountOfHensThirdAboutCurrentDayMinusThree();

        float percentHaleThirdCurrentDayMinusThree
                = (countEggOfThirdHaleByDescDateCurrentDayMinusThreeDay / (countHensOfThirdHaleByDescDateCurrentDayMinusThree
                * 1.0f)) * 100;

        model.addAttribute("countEggOfThirdHaleByDescDateMinusThree"
                , String.format("%.2f",percentHaleThirdCurrentDayMinusThree));

        //???? ?????????????? ?????? - 4 ??????
        Long countEggOfThirdHaleByDescDateCurrentDayMinusFourthDay
                = eggAddService.findThirdAndDateDescMinusFourthDay();

        Long countHensOfThirdHaleByDescDateCurrentDayMinusFourth
                = hensAddService.getCountOfHensThirdAboutCurrentDayMinusFourth();

        float percentHaleThirdCurrentDayMinusFourth
                = (countEggOfThirdHaleByDescDateCurrentDayMinusFourthDay / (countHensOfThirdHaleByDescDateCurrentDayMinusFourth * 1.0f)) * 100;

        model.addAttribute("countEggOfThirdHaleByDescDateMinusFourth"
                , String.format("%.2f",percentHaleThirdCurrentDayMinusFourth));

        //???? ?????????????? ?????? - 5 ??????
        Long countEggOfThirdHaleByDescDateCurrentDayMinusFiveDay
                = eggAddService.findThirdAndDateDescMinusFiveDay();

        Long countHensOfThirdHaleByDescDateCurrentDayMinusFive
                = hensAddService.getCountOfHensThirdAboutCurrentDayMinusFive();

        float percentHaleThirdCurrentDayMinusFive
                = (countEggOfThirdHaleByDescDateCurrentDayMinusFiveDay / (countHensOfThirdHaleByDescDateCurrentDayMinusFive * 1.0f)) * 100;

        model.addAttribute("countEggOfThirdHaleByDescDateMinusFive"
                , String.format("%.2f",percentHaleThirdCurrentDayMinusFive));

        //???? ?????????????? ?????? - 6 ??????
        Long countEggOfThirdHaleByDescDateCurrentDayMinusSixDay
                = eggAddService.findThirdAndDateDescMinusSixDay();

        Long countHensOfThirdHaleByDescDateCurrentDayMinusSix
                = hensAddService.getCountOfHensThirdAboutCurrentDayMinusSix();

        float percentHaleThirdCurrentDayMinusSix
                = (countEggOfThirdHaleByDescDateCurrentDayMinusSixDay  / (countHensOfThirdHaleByDescDateCurrentDayMinusSix * 1.0f)) * 100;

        model.addAttribute("countEggOfThirdHaleByDescDateMinusSix"
                , String.format("%.2f",percentHaleThirdCurrentDayMinusSix));

        //???? ?????????????? ?????? - 7 ??????
        Long countEggOfThirdHaleByDescDateCurrentDayMinusSevenDay
                = eggAddService.findThirdAndDateDescMinusSevenDay();

        Long countHensOfThirdHaleByDescDateCurrentDayMinusSeven
                = hensAddService.getCountOfHensThirdAboutCurrentDayMinusSeven();

        float percentHaleThirdCurrentDayMinusSeven
                = (countEggOfThirdHaleByDescDateCurrentDayMinusSevenDay / (countHensOfThirdHaleByDescDateCurrentDayMinusSeven * 1.0f)) * 100;

        model.addAttribute("countEggOfThirdHaleByDescDateMinusSeven"
                , String.format("%.2f",percentHaleThirdCurrentDayMinusSeven));


        //???? ???????? ???? ???????????? ???? ???????????????? ???????? ???? ?????????????? ??????
        Long countEggOfFourthHaleByDescDateCurrentDay
                = eggAddService.findByHaleFourthAndDateDescCurrentDay();

        Long countHensOfFourthHaleByDescDateCurrentDay
                = hensAddService.getCountOfHensFourthAboutCurrentDay();

        float percentHaleFourthCurrentDay
                = (countEggOfFourthHaleByDescDateCurrentDay / (countHensOfFourthHaleByDescDateCurrentDay * 1.0f)) * 100;

        model.addAttribute("countEggOfFourthHaleByDescDate"
                , String.format("%.2f",percentHaleFourthCurrentDay));

        //???? ?????????????? ?????? - 1 ??????
        Long countEggOfFourthHaleByDescDateCurrentDayMinusOneDay
                = eggAddService.findFourthAndDateDescMinusOneDay();

        Long countHensOfFourthHaleByDescDateCurrentDayMinusOne
                = hensAddService.getCountOfHensFourthAboutCurrentDayMinusOne();

        float percentHaleFourthCurrentDayMinusOne
                = (countEggOfFourthHaleByDescDateCurrentDayMinusOneDay/ (countHensOfFourthHaleByDescDateCurrentDayMinusOne * 1.0f)) * 100;

        model.addAttribute("countEggOfFourthHaleByDescDateMinusOne"
                , String.format("%.2f",percentHaleFourthCurrentDayMinusOne));

        //???? ?????????????? ?????? - 2 ??????
        Long countEggOfFourthHaleByDescDateCurrentDayMinusTwoDay
                = eggAddService.findFourthAndDateDescMinusTwoDay();

        Long countHensOfFourthHaleByDescDateCurrentDayMinusTwo
                = hensAddService.getCountOfHensFourthAboutCurrentDayMinusTwo();

        float percentHaleFourthCurrentDayMinusTwo
                = (countEggOfFourthHaleByDescDateCurrentDayMinusTwoDay/ (countHensOfFourthHaleByDescDateCurrentDayMinusTwo * 1.0f)) * 100;

        model.addAttribute("countEggOfFourthHaleByDescDateMinusTwo"
                , String.format("%.2f",percentHaleFourthCurrentDayMinusTwo));

        //???? ?????????????? ?????? - 3 ??????
        Long countEggOfFourthHaleByDescDateCurrentDayMinusThreeDay
                = eggAddService.findFourthAndDateDescMinusThreeDay();

        Long countHensOfFourthHaleByDescDateCurrentDayMinusThree
                = hensAddService.getCountOfHensFourthAboutCurrentDayMinusThree();

        float percentHaleFourthCurrentDayMinusThree
                = (countEggOfFourthHaleByDescDateCurrentDayMinusThreeDay / (countHensOfFourthHaleByDescDateCurrentDayMinusThree
                * 1.0f)) * 100;

        model.addAttribute("countEggOfFourthHaleByDescDateMinusThree"
                , String.format("%.2f",percentHaleFourthCurrentDayMinusThree));

        //???? ?????????????? ?????? - 4 ??????
        Long countEggOfFourthHaleByDescDateCurrentDayMinusFourthDay
                = eggAddService.findFourthAndDateDescMinusFourthDay();

        Long countHensOfFourthHaleByDescDateCurrentDayMinusFourth
                = hensAddService.getCountOfHensFourthAboutCurrentDayMinusFourth();

        float percentHaleFourthCurrentDayMinusFourth
                = (countEggOfFourthHaleByDescDateCurrentDayMinusFourthDay  / (countHensOfFourthHaleByDescDateCurrentDayMinusFourth * 1.0f)) * 100;

        model.addAttribute("countEggOfFourthHaleByDescDateMinusFourth"
                , String.format("%.2f",percentHaleFourthCurrentDayMinusFourth));

        //???? ?????????????? ?????? - 5 ??????
        Long countEggOfFourthHaleByDescDateCurrentDayMinusFiveDay
                = eggAddService.findFourthAndDateDescMinusFiveDay();

        Long countHensOfFourthHaleByDescDateCurrentDayMinusFive
                = hensAddService.getCountOfHensFourthAboutCurrentDayMinusFive();

        float percentHaleFourthCurrentDayMinusFive
                = (countEggOfFourthHaleByDescDateCurrentDayMinusFiveDay / (countHensOfFourthHaleByDescDateCurrentDayMinusFive * 1.0f)) * 100;

        model.addAttribute("countEggOfFourthHaleByDescDateMinusFive"
                , String.format("%.2f",percentHaleFourthCurrentDayMinusFive));

        //???? ?????????????? ?????? - 6 ??????
        Long countEggOfFourthHaleByDescDateCurrentDayMinusSixDay
                = eggAddService.findFourthAndDateDescMinusSixDay();

        Long countHensOfFourthHaleByDescDateCurrentDayMinusSix
                = hensAddService.getCountOfHensFourthAboutCurrentDayMinusSix();

        float percentHaleFourthCurrentDayMinusSix
                = (countEggOfFourthHaleByDescDateCurrentDayMinusSixDay / (countHensOfFourthHaleByDescDateCurrentDayMinusSix * 1.0f)) * 100;

        model.addAttribute("countEggOfFourthHaleByDescDateMinusSix"
                , String.format("%.2f",percentHaleFourthCurrentDayMinusSix));

        //???? ?????????????? ?????? - 7 ??????
        Long countEggOfFourthHaleByDescDateCurrentDayMinusSevenDay
                = eggAddService.findFourthAndDateDescMinusSevenDay();

        Long countHensOfFourthHaleByDescDateCurrentDayMinusSeven
                = hensAddService.getCountOfHensFourthAboutCurrentDayMinusSeven();

        float percentHaleFourthCurrentDayMinusSeven
                = (countEggOfFourthHaleByDescDateCurrentDayMinusSevenDay  / (countHensOfFourthHaleByDescDateCurrentDayMinusSeven * 1.0f)) * 100;

        model.addAttribute("countEggOfFourthHaleByDescDateMinusSeven"
                , String.format("%.2f",percentHaleFourthCurrentDayMinusSeven));


        //???? ???????? ???? ???????????? ???? ???????? ???????? ???? ?????????????? ??????
        Long countEggOfFiveHaleByDescDateCurrentDay
                = eggAddService.findByHaleFiveAndDateDescCurrentDay();

        Long countHensOfFiveHaleByDescDateCurrentDay
                = hensAddService.getCountOfHensFiveAboutCurrentDay();

        float percentHaleFiveCurrentDay
                = (countEggOfFiveHaleByDescDateCurrentDay / (countHensOfFiveHaleByDescDateCurrentDay * 1.0f)) * 100;

        model.addAttribute("countEggOfFiveHaleByDescDate"
                , String.format("%.2f",percentHaleFiveCurrentDay));

        //???? ?????????????? ?????? - 1 ??????
        Long countEggOfFiveHaleByDescDateCurrentDayMinusOneDay
                = eggAddService.findFiveAndDateDescMinusOneDay();

        Long countHensOfFiveHaleByDescDateCurrentDayMinusOne
                = hensAddService.getCountOfHensFiveAboutCurrentDayMinusOne();

        float percentHaleFiveCurrentDayMinusOne
                = (countEggOfFiveHaleByDescDateCurrentDayMinusOneDay / (countHensOfFiveHaleByDescDateCurrentDayMinusOne * 1.0f)) * 100;

        model.addAttribute("countEggOfFiveHaleByDescDateMinusOne"
                , String.format("%.2f",percentHaleFiveCurrentDayMinusOne));

        //???? ?????????????? ?????? - 2 ??????
        Long countEggOfFiveHaleByDescDateCurrentDayMinusTwoDay
                = eggAddService.findFiveAndDateDescMinusTwoDay();

        Long countHensOfFiveHaleByDescDateCurrentDayMinusTwo
                = hensAddService.getCountOfHensFiveAboutCurrentDayMinusTwo();

        float percentHaleFiveCurrentDayMinusTwo
                = (countEggOfFiveHaleByDescDateCurrentDayMinusTwoDay / (countHensOfFiveHaleByDescDateCurrentDayMinusTwo * 1.0f)) * 100;

        model.addAttribute("countEggOfFiveHaleByDescDateMinusTwo"
                , String.format("%.2f",percentHaleFiveCurrentDayMinusTwo));

        //???? ?????????????? ?????? - 3 ??????
        Long countEggOfFiveHaleByDescDateCurrentDayMinusThreeDay
                = eggAddService.findFiveAndDateDescMinusThreeDay();

        Long countHensOfFiveHaleByDescDateCurrentDayMinusThree
                = hensAddService.getCountOfHensFiveAboutCurrentDayMinusThree();

        float percentHaleFiveCurrentDayMinusThree
                = (countEggOfFiveHaleByDescDateCurrentDayMinusThreeDay / (countHensOfFiveHaleByDescDateCurrentDayMinusThree
                * 1.0f)) * 100;

        model.addAttribute("countEggOfFiveHaleByDescDateMinusThree"
                , String.format("%.2f",percentHaleFiveCurrentDayMinusThree));

        //???? ?????????????? ?????? - 4 ??????
        Long countEggOfFiveHaleByDescDateCurrentDayMinusFourthDay
                = eggAddService.findFiveAndDateDescMinusFourthDay();

        Long countHensOfFiveHaleByDescDateCurrentDayMinusFourth
                = hensAddService.getCountOfHensFiveAboutCurrentDayMinusFourth();

        float percentHaleFiveCurrentDayMinusFourth
                = (countEggOfFiveHaleByDescDateCurrentDayMinusFourthDay / (countHensOfFiveHaleByDescDateCurrentDayMinusFourth * 1.0f)) * 100;

        model.addAttribute("countEggOfFiveHaleByDescDateMinusFourth"
                , String.format("%.2f",percentHaleFiveCurrentDayMinusFourth));

        //???? ?????????????? ?????? - 5 ??????
        Long countEggOfFiveHaleByDescDateCurrentDayMinusFiveDay
                = eggAddService.findFiveAndDateDescMinusFiveDay();

        Long countHensOfFiveHaleByDescDateCurrentDayMinusFive
                = hensAddService.getCountOfHensFiveAboutCurrentDayMinusFive();

        float percentHaleFiveCurrentDayMinusFive
                = (countEggOfFiveHaleByDescDateCurrentDayMinusFiveDay / (countHensOfFiveHaleByDescDateCurrentDayMinusFive * 1.0f)) * 100;

        model.addAttribute("countEggOfFiveHaleByDescDateMinusFive"
                , String.format("%.2f",percentHaleFiveCurrentDayMinusFive));

        //???? ?????????????? ?????? - 6 ??????
        Long countEggOfFiveHaleByDescDateCurrentDayMinusSixDay
                = eggAddService.findFiveAndDateDescMinusSixDay();

        Long countHensOfFiveHaleByDescDateCurrentDayMinusSix
                = hensAddService.getCountOfHensFiveAboutCurrentDayMinusSix();

        float percentHaleFiveCurrentDayMinusSix
                = (countEggOfFiveHaleByDescDateCurrentDayMinusSixDay / (countHensOfFiveHaleByDescDateCurrentDayMinusSix * 1.0f)) * 100;

        model.addAttribute("countEggOfFiveHaleByDescDateMinusSix"
                , String.format("%.2f",percentHaleFiveCurrentDayMinusSix));

        //???? ?????????????? ?????? - 7 ??????
        Long countEggOfFiveHaleByDescDateCurrentDayMinusSevenDay
                = eggAddService.findFiveAndDateDescMinusSevenDay();

        Long countHensOfFiveHaleByDescDateCurrentDayMinusSeven
                = hensAddService.getCountOfHensFiveAboutCurrentDayMinusSeven();

        float percentHaleFiveCurrentDayMinusSeven
                = (countEggOfFiveHaleByDescDateCurrentDayMinusSevenDay / (countHensOfFiveHaleByDescDateCurrentDayMinusSeven * 1.0f)) * 100;

        model.addAttribute("countEggOfFiveHaleByDescDateMinusSeven"
                , String.format("%.2f",percentHaleFiveCurrentDayMinusSeven));


        //???? ???????? ???? ???????????? ???? ?????????? ???????? ???? ?????????????? ??????
        Long countEggOfSixHaleByDescDateCurrentDay
                = eggAddService.findByHaleSixAndDateDescCurrentDay();

        Long countHensOfSixHaleByDescDateCurrentDay
                = hensAddService.getCountOfHensSixAboutCurrentDay();

        float percentHaleSixCurrentDay
                = (countEggOfSixHaleByDescDateCurrentDay / (countHensOfSixHaleByDescDateCurrentDay * 1.0f)) * 100;

        model.addAttribute("countEggOfSixHaleByDescDate"
                , String.format("%.2f",percentHaleSixCurrentDay));

        //???? ?????????????? ?????? - 1 ??????
        Long countEggOfSixHaleByDescDateCurrentDayMinusOneDay
                = eggAddService.findSixAndDateDescMinusOneDay();

        Long countHensOfSixHaleByDescDateCurrentDayMinusOne
                = hensAddService.getCountOfHensSixAboutCurrentDayMinusOne();

        float percentHaleSixCurrentDayMinusOne
                = (countEggOfSixHaleByDescDateCurrentDayMinusOneDay / (countHensOfSixHaleByDescDateCurrentDayMinusOne * 1.0f)) * 100;

        model.addAttribute("countEggOfSixHaleByDescDateMinusOne"
                , String.format("%.2f",percentHaleSixCurrentDayMinusOne));

        //???? ?????????????? ?????? - 2 ??????
        Long countEggOfSixHaleByDescDateCurrentDayMinusTwoDay
                = eggAddService.findSixAndDateDescMinusTwoDay();

        Long countHensOfSixHaleByDescDateCurrentDayMinusTwo
                = hensAddService.getCountOfHensSixAboutCurrentDayMinusTwo();

        float percentHaleSixCurrentDayMinusTwo
                = (countEggOfSixHaleByDescDateCurrentDayMinusTwoDay / (countHensOfSixHaleByDescDateCurrentDayMinusTwo * 1.0f)) * 100;

        model.addAttribute("countEggOfSixHaleByDescDateMinusTwo"
                , String.format("%.2f",percentHaleSixCurrentDayMinusTwo));

        //???? ?????????????? ?????? - 3 ??????
        Long countEggOfSixHaleByDescDateCurrentDayMinusThreeDay
                = eggAddService.findSixAndDateDescMinusThreeDay();

        Long countHensOfSixHaleByDescDateCurrentDayMinusThree
                = hensAddService.getCountOfHensSixAboutCurrentDayMinusThree();

        float percentHaleSixCurrentDayMinusThree
                = (countEggOfSixHaleByDescDateCurrentDayMinusThreeDay / (countHensOfSixHaleByDescDateCurrentDayMinusThree
                * 1.0f)) * 100;

        model.addAttribute("countEggOfSixHaleByDescDateMinusThree"
                , String.format("%.2f",percentHaleSixCurrentDayMinusThree));

        //???? ?????????????? ?????? - 4 ??????
        Long countEggOfSixHaleByDescDateCurrentDayMinusFourthDay
                = eggAddService.findSixAndDateDescMinusFourthDay();

        Long countHensOfSixHaleByDescDateCurrentDayMinusFourth
                = hensAddService.getCountOfHensSixAboutCurrentDayMinusFourth();

        float percentHaleSixCurrentDayMinusFourth
                = (countEggOfSixHaleByDescDateCurrentDayMinusFourthDay / (countHensOfSixHaleByDescDateCurrentDayMinusFourth * 1.0f)) * 100;

        model.addAttribute("countEggOfSixHaleByDescDateMinusFourth"
                , String.format("%.2f",percentHaleSixCurrentDayMinusFourth));

        //???? ?????????????? ?????? - 5 ??????
        Long countEggOfSixHaleByDescDateCurrentDayMinusFiveDay
                = eggAddService.findSixAndDateDescMinusFiveDay();

        Long countHensOfSixHaleByDescDateCurrentDayMinusFive
                = hensAddService.getCountOfHensSixAboutCurrentDayMinusFive();

        float percentHaleSixCurrentDayMinusFive
                = (countEggOfSixHaleByDescDateCurrentDayMinusFiveDay / (countHensOfSixHaleByDescDateCurrentDayMinusFive * 1.0f)) * 100;

        model.addAttribute("countEggOfSixHaleByDescDateMinusFive"
                , String.format("%.2f",percentHaleSixCurrentDayMinusFive));

        //???? ?????????????? ?????? - 6 ??????
        Long countEggOfSixHaleByDescDateCurrentDayMinusSixDay
                = eggAddService.findSixAndDateDescMinusSixDay();

        Long countHensOfSixHaleByDescDateCurrentDayMinusSix
                = hensAddService.getCountOfHensSixAboutCurrentDayMinusSix();

        float percentHaleSixCurrentDayMinusSix
                = (countEggOfSixHaleByDescDateCurrentDayMinusSixDay / (countHensOfSixHaleByDescDateCurrentDayMinusSix * 1.0f)) * 100;

        model.addAttribute("countEggOfSixHaleByDescDateMinusSix"
                , String.format("%.2f",percentHaleSixCurrentDayMinusSix));

        //???? ?????????????? ?????? - 7 ??????
        Long countEggOfSixHaleByDescDateCurrentDayMinusSevenDay
                = eggAddService.findSixAndDateDescMinusSevenDay();

        Long countHensOfSixHaleByDescDateCurrentDayMinusSeven
                = hensAddService.getCountOfHensSixAboutCurrentDayMinusSeven();

        float percentHaleSixCurrentDayMinusSeven
                = (countEggOfSixHaleByDescDateCurrentDayMinusSevenDay / (countHensOfSixHaleByDescDateCurrentDayMinusSeven * 1.0f)) * 100;

        model.addAttribute("countEggOfSixHaleByDescDateMinusSeven"
                , String.format("%.2f",percentHaleSixCurrentDayMinusSeven));


        //???? ???????? ???? ???????????? ???? ?????????? ???????? ???? ?????????????? ??????
        Long countEggOfSevenHaleByDescDateCurrentDay
                = eggAddService.findByHaleSevenAndDateDescCurrentDay();

        Long countHensOfSevenHaleByDescDateCurrentDay
                = hensAddService.getCountOfHensSevenAboutCurrentDay();

        float percentHaleSevenCurrentDay
                = (countEggOfSevenHaleByDescDateCurrentDay / (countHensOfSevenHaleByDescDateCurrentDay * 1.0f)) * 100;

        model.addAttribute("countEggOfSevenHaleByDescDate"
                , String.format("%.2f",percentHaleSevenCurrentDay));

        //???? ?????????????? ?????? - 1 ??????
        Long countEggOfSevenHaleByDescDateCurrentDayMinusOneDay
                = eggAddService.findSevenAndDateDescMinusOneDay();

        Long countHensOfSevenHaleByDescDateCurrentDayMinusOne
                = hensAddService.getCountOfHensSevenAboutCurrentDayMinusOne();

        float percentHaleSevenCurrentDayMinusOne
                = (countEggOfSevenHaleByDescDateCurrentDayMinusOneDay / (countHensOfSevenHaleByDescDateCurrentDayMinusOne * 1.0f)) * 100;

        model.addAttribute("countEggOfSevenHaleByDescDateMinusOne"
                , String.format("%.2f",percentHaleSevenCurrentDayMinusOne));

        //???? ?????????????? ?????? - 2 ??????
        Long countEggOfSevenHaleByDescDateCurrentDayMinusTwoDay
                = eggAddService.findSevenAndDateDescMinusTwoDay();

        Long countHensOfSevenHaleByDescDateCurrentDayMinusTwo
                = hensAddService.getCountOfHensSevenAboutCurrentDayMinusTwo();

        float percentHaleSevenCurrentDayMinusTwo
                = (countEggOfSevenHaleByDescDateCurrentDayMinusTwoDay / (countHensOfSevenHaleByDescDateCurrentDayMinusTwo * 1.0f)) * 100;

        model.addAttribute("countEggOfSevenHaleByDescDateMinusTwo"
                , String.format("%.2f",percentHaleSevenCurrentDayMinusTwo));

        //???? ?????????????? ?????? - 3 ??????
        Long countEggOfSevenHaleByDescDateCurrentDayMinusThreeDay
                = eggAddService.findSevenAndDateDescMinusThreeDay();

        Long countHensOfSevenHaleByDescDateCurrentDayMinusThree
                = hensAddService.getCountOfHensSevenAboutCurrentDayMinusThree();

        float percentHaleSevenCurrentDayMinusThree
                = (countEggOfSevenHaleByDescDateCurrentDayMinusThreeDay / (countHensOfSevenHaleByDescDateCurrentDayMinusThree
                * 1.0f)) * 100;

        model.addAttribute("countEggOfSevenHaleByDescDateMinusThree"
                , String.format("%.2f",percentHaleSevenCurrentDayMinusThree));

        //???? ?????????????? ?????? - 4 ??????
        Long countEggOfSevenHaleByDescDateCurrentDayMinusFourthDay
                = eggAddService.findSevenAndDateDescMinusFourthDay();

        Long countHensOfSevenHaleByDescDateCurrentDayMinusFourth
                = hensAddService.getCountOfHensSevenAboutCurrentDayMinusFourth();

        float percentHaleSevenCurrentDayMinusFourth
                = (countEggOfSevenHaleByDescDateCurrentDayMinusFourthDay / (countHensOfSevenHaleByDescDateCurrentDayMinusFourth * 1.0f)) * 100;

        model.addAttribute("countEggOfSevenHaleByDescDateMinusFourth"
                , String.format("%.2f",percentHaleSevenCurrentDayMinusFourth));

        //???? ?????????????? ?????? - 5 ??????
        Long countEggOfSevenHaleByDescDateCurrentDayMinusFiveDay
                = eggAddService.findSevenAndDateDescMinusFiveDay();

        Long countHensOfSevenHaleByDescDateCurrentDayMinusFive
                = hensAddService.getCountOfHensSevenAboutCurrentDayMinusFive();

        float percentHaleSevenCurrentDayMinusFive
                = (countEggOfSevenHaleByDescDateCurrentDayMinusFiveDay / (countHensOfSevenHaleByDescDateCurrentDayMinusFive * 1.0f)) * 100;

        model.addAttribute("countEggOfSevenHaleByDescDateMinusFive"
                , String.format("%.2f",percentHaleSevenCurrentDayMinusFive));

        //???? ?????????????? ?????? - 6 ??????
        Long countEggOfSevenHaleByDescDateCurrentDayMinusSixDay
                = eggAddService.findSevenAndDateDescMinusSixDay();

        Long countHensOfSevenHaleByDescDateCurrentDayMinusSix
                = hensAddService.getCountOfHensSevenAboutCurrentDayMinusSix();

        float percentHaleSevenCurrentDayMinusSix
                = (countEggOfSevenHaleByDescDateCurrentDayMinusSixDay / (countHensOfSevenHaleByDescDateCurrentDayMinusSix * 1.0f)) * 100;

        model.addAttribute("countEggOfSevenHaleByDescDateMinusSix"
                , String.format("%.2f",percentHaleSevenCurrentDayMinusSix));

        //???? ?????????????? ?????? - 7 ??????
        Long countEggOfSevenHaleByDescDateCurrentDayMinusSevenDay
                = eggAddService.findSevenAndDateDescMinusSevenDay();

        Long countHensOfSevenHaleByDescDateCurrentDayMinusSeven
                = hensAddService.getCountOfHensSevenAboutCurrentDayMinusSeven();

        float percentHaleSevenCurrentDayMinusSeven
                = (countEggOfSevenHaleByDescDateCurrentDayMinusSevenDay / (countHensOfSevenHaleByDescDateCurrentDayMinusSeven * 1.0f)) * 100;

        model.addAttribute("countEggOfSevenHaleByDescDateMinusSeven"
                , String.format("%.2f",percentHaleSevenCurrentDayMinusSeven));


        //???? ???????? ???? ???????????? ???? ???????? ???????? ???? ?????????????? ??????
        Long countEggOfEightHaleByDescDateCurrentDay
                = eggAddService.findByHaleEightAndDateDescCurrentDay();

        Long countHensOfEightHaleByDescDateCurrentDay
                = hensAddService.getCountOfHensEightAboutCurrentDay();

        float percentHaleEightCurrentDay
                = (countEggOfEightHaleByDescDateCurrentDay / (countHensOfEightHaleByDescDateCurrentDay * 1.0f)) * 100;

        model.addAttribute("countEggOfEightHaleByDescDate"
                , String.format("%.2f",percentHaleEightCurrentDay));

        //???? ?????????????? ?????? - 1 ??????
        Long countEggOfEightHaleByDescDateCurrentDayMinusOneDay
                = eggAddService.findEightAndDateDescMinusOneDay();

        Long countHensOfEightHaleByDescDateCurrentDayMinusOne
                = hensAddService.getCountOfHensEightAboutCurrentDayMinusOne();

        float percentHaleEightCurrentDayMinusOne
                = (countEggOfEightHaleByDescDateCurrentDayMinusOneDay / (countHensOfEightHaleByDescDateCurrentDayMinusOne * 1.0f)) * 100;

        model.addAttribute("countEggOfEightHaleByDescDateMinusOne"
                , String.format("%.2f",percentHaleEightCurrentDayMinusOne));

        //???? ?????????????? ?????? - 2 ??????
        Long countEggOfEightHaleByDescDateCurrentDayMinusTwoDay
                = eggAddService.findEightAndDateDescMinusTwoDay();

        Long countHensOfEightHaleByDescDateCurrentDayMinusTwo
                = hensAddService.getCountOfHensEightAboutCurrentDayMinusTwo();

        float percentHaleEightCurrentDayMinusTwo
                = (countEggOfEightHaleByDescDateCurrentDayMinusTwoDay / (countHensOfEightHaleByDescDateCurrentDayMinusTwo * 1.0f)) * 100;

        model.addAttribute("countEggOfEightHaleByDescDateMinusTwo"
                , String.format("%.2f",percentHaleEightCurrentDayMinusTwo));

        //???? ?????????????? ?????? - 3 ??????
        Long countEggOfEightHaleByDescDateCurrentDayMinusThreeDay
                = eggAddService.findEightAndDateDescMinusThreeDay();

        Long countHensOfEightHaleByDescDateCurrentDayMinusThree
                = hensAddService.getCountOfHensEightAboutCurrentDayMinusThree();

        float percentHaleEightCurrentDayMinusThree
                = (countEggOfEightHaleByDescDateCurrentDayMinusThreeDay / (countHensOfEightHaleByDescDateCurrentDayMinusThree
                * 1.0f)) * 100;

        model.addAttribute("countEggOfEightHaleByDescDateMinusThree"
                , String.format("%.2f",percentHaleEightCurrentDayMinusThree));

        //???? ?????????????? ?????? - 4 ??????
        Long countEggOfEightHaleByDescDateCurrentDayMinusFourthDay
                = eggAddService.findEightAndDateDescMinusFourthDay();

        Long countHensOfEightHaleByDescDateCurrentDayMinusFourth
                = hensAddService.getCountOfHensEightAboutCurrentDayMinusFourth();

        float percentHaleEightCurrentDayMinusFourth
                = (countEggOfEightHaleByDescDateCurrentDayMinusFourthDay / (countHensOfEightHaleByDescDateCurrentDayMinusFourth * 1.0f)) * 100;

        model.addAttribute("countEggOfEightHaleByDescDateMinusFourth"
                , String.format("%.2f",percentHaleEightCurrentDayMinusFourth));

        //???? ?????????????? ?????? - 5 ??????
        Long countEggOfEightHaleByDescDateCurrentDayMinusFiveDay
                = eggAddService.findEightAndDateDescMinusFiveDay();

        Long countHensOfEightHaleByDescDateCurrentDayMinusFive
                = hensAddService.getCountOfHensEightAboutCurrentDayMinusFive();

        float percentHaleEightCurrentDayMinusFive
                = (countEggOfEightHaleByDescDateCurrentDayMinusFiveDay / (countHensOfEightHaleByDescDateCurrentDayMinusFive * 1.0f)) * 100;

        model.addAttribute("countEggOfEightHaleByDescDateMinusFive"
                , String.format("%.2f",percentHaleEightCurrentDayMinusFive));

        //???? ?????????????? ?????? - 6 ??????
        Long countEggOfEightHaleByDescDateCurrentDayMinusSixDay
                = eggAddService.findEightAndDateDescMinusSixDay();

        Long countHensOfEightHaleByDescDateCurrentDayMinusSix
                = hensAddService.getCountOfHensEightAboutCurrentDayMinusSix();

        float percentHaleEightCurrentDayMinusSix
                = (countEggOfEightHaleByDescDateCurrentDayMinusSixDay / (countHensOfEightHaleByDescDateCurrentDayMinusSix * 1.0f)) * 100;

        model.addAttribute("countEggOfEightHaleByDescDateMinusSix"
                , String.format("%.2f",percentHaleEightCurrentDayMinusSix));

        //???? ?????????????? ?????? - 7 ??????
        Long countEggOfEightHaleByDescDateCurrentDayMinusSevenDay
                = eggAddService.findEightAndDateDescMinusSevenDay();

        Long countHensOfEightHaleByDescDateCurrentDayMinusSeven
                = hensAddService.getCountOfHensEightAboutCurrentDayMinusSeven();

        float percentHaleEightCurrentDayMinusSeven
                = (countEggOfEightHaleByDescDateCurrentDayMinusSevenDay / (countHensOfEightHaleByDescDateCurrentDayMinusSeven * 1.0f)) * 100;

        model.addAttribute("countEggOfEightHaleByDescDateMinusSeven"
                , String.format("%.2f",percentHaleEightCurrentDayMinusSeven));


        //???? ???????? ???? ???????????? ???? ???????????? ???????? ???? ?????????????? ??????
        Long countEggOfNinthHaleByDescDateCurrentDay
                = eggAddService.findByHaleNinthAndDateDescCurrentDay();

        Long countHensOfNinthHaleByDescDateCurrentDay
                = hensAddService.getCountOfHensNinthAboutCurrentDay();

        float percentHaleNinthCurrentDay
                = (countEggOfNinthHaleByDescDateCurrentDay / (countHensOfNinthHaleByDescDateCurrentDay * 1.0f)) * 100;

        model.addAttribute("countEggOfNinthHaleByDescDate"
                , String.format("%.2f",percentHaleNinthCurrentDay));

        //???? ?????????????? ?????? - 1 ??????
        Long countEggOfNinthHaleByDescDateCurrentDayMinusOneDay
                = eggAddService.findNinthAndDateDescMinusOneDay();

        Long countHensOfNinthHaleByDescDateCurrentDayMinusOne
                = hensAddService.getCountOfHensNinthAboutCurrentDayMinusOne();

        float percentHaleNinthCurrentDayMinusOne
                = (countEggOfNinthHaleByDescDateCurrentDayMinusOneDay / (countHensOfNinthHaleByDescDateCurrentDayMinusOne * 1.0f)) * 100;

        model.addAttribute("countEggOfNinthHaleByDescDateMinusOne"
                , String.format("%.2f",percentHaleNinthCurrentDayMinusOne));

        //???? ?????????????? ?????? - 2 ??????
        Long countEggOfNinthHaleByDescDateCurrentDayMinusTwoDay
                = eggAddService.findNinthAndDateDescMinusTwoDay();

        Long countHensOfNinthHaleByDescDateCurrentDayMinusTwo
                = hensAddService.getCountOfHensNinthAboutCurrentDayMinusTwo();

        float percentHaleNinthCurrentDayMinusTwo
                = (countEggOfNinthHaleByDescDateCurrentDayMinusTwoDay / (countHensOfNinthHaleByDescDateCurrentDayMinusTwo * 1.0f)) * 100;

        model.addAttribute("countEggOfNinthHaleByDescDateMinusTwo"
                , String.format("%.2f",percentHaleNinthCurrentDayMinusTwo));

        //???? ?????????????? ?????? - 3 ??????
        Long countEggOfNinthHaleByDescDateCurrentDayMinusThreeDay
                = eggAddService.findNinthAndDateDescMinusThreeDay();

        Long countHensOfNinthHaleByDescDateCurrentDayMinusThree
                = hensAddService.getCountOfHensNinthAboutCurrentDayMinusThree();

        float percentHaleNinthCurrentDayMinusThree
                = (countEggOfNinthHaleByDescDateCurrentDayMinusThreeDay / (countHensOfNinthHaleByDescDateCurrentDayMinusThree
                * 1.0f)) * 100;

        model.addAttribute("countEggOfNinthHaleByDescDateMinusThree"
                , String.format("%.2f",percentHaleNinthCurrentDayMinusThree));

        //???? ?????????????? ?????? - 4 ??????
        Long countEggOfNinthHaleByDescDateCurrentDayMinusFourthDay
                = eggAddService.findNinthAndDateDescMinusFourthDay();

        Long countHensOfNinthHaleByDescDateCurrentDayMinusFourth
                = hensAddService.getCountOfHensNinthAboutCurrentDayMinusFourth();

        float percentHaleNinthCurrentDayMinusFourth
                = (countEggOfNinthHaleByDescDateCurrentDayMinusFourthDay / (countHensOfNinthHaleByDescDateCurrentDayMinusFourth * 1.0f)) * 100;

        model.addAttribute("countEggOfNinthHaleByDescDateMinusFourth"
                , String.format("%.2f",percentHaleNinthCurrentDayMinusFourth));

        //???? ?????????????? ?????? - 5 ??????
        Long countEggOfNinthHaleByDescDateCurrentDayMinusFiveDay
                = eggAddService.findNinthAndDateDescMinusFiveDay();

        Long countHensOfNinthHaleByDescDateCurrentDayMinusFive
                = hensAddService.getCountOfHensNinthAboutCurrentDayMinusFive();

        float percentHaleNinthCurrentDayMinusFive
                = (countEggOfNinthHaleByDescDateCurrentDayMinusFiveDay / (countHensOfNinthHaleByDescDateCurrentDayMinusFive * 1.0f)) * 100;

        model.addAttribute("countEggOfNinthHaleByDescDateMinusFive"
                , String.format("%.2f",percentHaleNinthCurrentDayMinusFive));

        //???? ?????????????? ?????? - 6 ??????
        Long countEggOfNinthHaleByDescDateCurrentDayMinusSixDay
                = eggAddService.findNinthAndDateDescMinusSixDay();

        Long countHensOfNinthHaleByDescDateCurrentDayMinusSix
                = hensAddService.getCountOfHensNinthAboutCurrentDayMinusSix();

        float percentHaleNinthCurrentDayMinusSix
                = (countEggOfNinthHaleByDescDateCurrentDayMinusSixDay / (countHensOfNinthHaleByDescDateCurrentDayMinusSix * 1.0f)) * 100;

        model.addAttribute("countEggOfNinthHaleByDescDateMinusSix"
                , String.format("%.2f",percentHaleNinthCurrentDayMinusSix));

        //???? ?????????????? ?????? - 7 ??????
        Long countEggOfNinthHaleByDescDateCurrentDayMinusSevenDay
                = eggAddService.findNinthAndDateDescMinusSevenDay();

        Long countHensOfNinthHaleByDescDateCurrentDayMinusSeven
                = hensAddService.getCountOfHensNinthAboutCurrentDayMinusSeven();

        float percentHaleNinthCurrentDayMinusSeven
                = (countEggOfNinthHaleByDescDateCurrentDayMinusSevenDay / (countHensOfNinthHaleByDescDateCurrentDayMinusSeven * 1.0f)) * 100;

        model.addAttribute("countEggOfNinthHaleByDescDateMinusSeven"
                , String.format("%.2f",percentHaleNinthCurrentDayMinusSeven));

        System.out.println();

        return "percentage-table";
    }





}
