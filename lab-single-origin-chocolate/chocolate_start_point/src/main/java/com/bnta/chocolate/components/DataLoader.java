package com.bnta.chocolate.components;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.services.ChocolateService;
import com.bnta.chocolate.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner{


    @Autowired
    ChocolateService chocolateService;

    @Autowired
    EstateService estateService;

    @Override
    public void run(ApplicationArguments args) throws Exception{

        Estate GoodChocolateEstate = new Estate("Good Chocolate Estate", "Columbia");
        Estate BadChocolateEstate = new Estate("Bad Chocolate Estate", "USA");

        estateService.addEstate(GoodChocolateEstate);
        estateService.addEstate(BadChocolateEstate);

        Chocolate bounty = new Chocolate("Bounty", 5, GoodChocolateEstate);
        Chocolate twirl = new Chocolate("Twirl", 30, GoodChocolateEstate );
        Chocolate beastBars = new Chocolate("Beast Bars", 20, BadChocolateEstate);
        Chocolate grenadePeanutNutter = new Chocolate("Grenade Peanut Butter",25, GoodChocolateEstate );
        Chocolate lion = new Chocolate("Lion", 30, BadChocolateEstate);
        Chocolate crunchie = new Chocolate("Crunchie", 15, BadChocolateEstate);

        chocolateService.addChocolate(bounty);
        chocolateService.addChocolate(twirl);
        chocolateService.addChocolate(beastBars);
        chocolateService.addChocolate(grenadePeanutNutter);
        chocolateService.addChocolate(lion);
        chocolateService.addChocolate(crunchie);
    }

}
