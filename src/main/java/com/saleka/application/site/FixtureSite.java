package com.saleka.application.site;

import com.saleka.application.configuration.ConfigurationSite;
import com.saleka.application.configuration.ConfigurationSiteRepository;
import com.saleka.application.security.User;
import com.saleka.application.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Scanner;

@Component
public class FixtureSite implements
        ApplicationListener<ContextRefreshedEvent> {
    boolean alreadySetup = true;
    @Autowired
    private ConfigurationSiteRepository configurationSiteRepository;
    private UserRepository userRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(alreadySetup){
            return;
        }
        if(userRepository.findAll().isEmpty()){
            System.out.println("\n\n\n\n\n les users ne sont pas encore prets \n\n\n\n\n");
            return;
        }
        List<User> users = userRepository.findAll();
        ConfigurationSite configurationSite = new ConfigurationSite();
        configurationSite.setTheme("Saleka Web Site");


        /**
         * TOP BAR FIXTURE
         */
        configurationSite.setEmailCorp("saleka@support.com");
        configurationSite.setTelCorp("+237 695267478");
        configurationSite.setSloganCorp("Votre Satisfaction, Notre Bonheur");

        /**
         * HERO SECTION
         */
        configurationSite.setTitrePrincipal("Bienvenue Chez Saleka");
        configurationSite.setSousTitrePrincipal("Nous sommes une entreprise de prestations de services informatiques");
        configurationSite.setImagePrincipal("saleka");

        /**
         * Why-US
         */
        //Bloc 1
        configurationSite.setBloc1WhyusTitre("Pourquoi nous Choisir pour vos projets informatiques");
        configurationSite.setBloc1WhyusSousTitre("Une jeune equipe dynamique ?? votre service.");

        //Bloc 2
        //Boite 1
        configurationSite.setBloc2WhyusBoite1Titre("Developpement d'apllications");
        configurationSite.setBloc2WhyusBoite1SousTitre("Nous d??veloppons des applications robustes et sophistiqu??es afin de booster la croissance de votre entreprise.");
        //Boite 2
        configurationSite.setBloc2WhyusBoite2Titre("Developpement d'applications Web");
        configurationSite.setBloc2WhyusBoite2SousTitre("Des applications ergonomiques et s??curis??es, facilitant l???acc??s ?? vos services sur le web, afin d???accro??tre votre visibilit?? internationale.");

        //Boite 3
        configurationSite.setBloc2WhyusBoite3Titre("Developpement d'applications mobiles");
        configurationSite.setBloc2WhyusBoite3SousTitre("Nous am??liorons vos produits logiciels pour les adapter au mieux ?? l?????volution de votre march?? et de l???environnement socio-??conomique.");

        /**
         * Service
         */
        configurationSite.setTitreService("Des services de haute qualit?? ?? un prix abordable.");
        configurationSite.setDescriptionService("Non seulement nous fournissons des services fiables et de haute qualit??, nous nous engageons ??galement ?? les fournir ?? un prix abordable.");
        //Bloc 1
        configurationSite.setBloc1ServiceTitre1("D??veloppement d???applications JAVA");
        configurationSite.setBloc1ServiceSoustitre1("Optez pour une application b??n??ficiant de la maturit?? du langage de programmation JAVA, ?? laquelle vous pourrez confier toutes les t??ches lourdes et critiques de votre business.\n" +
                "\n" +
                "Nous concevons des applications d???entreprises JAVA taill??es pour votre m??tier.");
        //bloc 2
        configurationSite.setBloc1ServiceTitre2("D??veloppement d???APIs WEB");
        configurationSite.setBloc1ServiceSoustitre2("Que vous fassiez du B2C ou du B2B, appuyez-vous sur la puissance des APIs Web pour fournir vos services digitaux sur mesure ?? des milliers de clients ?? moindre co??t.\n" +
                "\n" +
                "D??velopper des APIs oui, mais surtout les s??curiser: nous en sommes conscients et mettons ces avantages ?? votre port??e.");
        //Bloc3
        configurationSite.setBloc1ServiceTitre3("Conception d'interfaces graphiques");
        //configurationSite.setBloc1ServiceSoustitre3();

    }
}
