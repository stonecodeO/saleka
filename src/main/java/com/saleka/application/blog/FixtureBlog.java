package com.saleka.application.blog;

import com.saleka.application.blog.category.Category;
import com.saleka.application.blog.category.CategoryRepository;
import com.saleka.application.blog.comment.Comment;
import com.saleka.application.blog.comment.CommentRepository;
import com.saleka.application.blog.post.Post;
import com.saleka.application.blog.post.PostRepository;
import com.saleka.application.blog.tag.Tag;
import com.saleka.application.blog.tag.TagRepository;
import com.saleka.application.configuration.ConfigurationSiteRepository;
import com.saleka.application.security.User;
import com.saleka.application.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.*;

@Component
public class FixtureBlog implements
        ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = true;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;

        //Creation des tags de posts

        if(userRepository.findAll().isEmpty()){
            System.out.println("\n\n\n\n\n les users ne sont pas encore prets \n\n\n\n\n");
            return;
        }

        List<User> users = userRepository.findAll();

        List<Tag> tags = new ArrayList<>();

        Tag ntic = new Tag();
        ntic.setKey("NTIC");
        tags.add(ntic);

        Tag business = new Tag();
        business.setKey("BUSINESS");
        tags.add(business);

        Tag mac = new Tag();
        mac.setKey("MAC");
        tags.add(mac);

        Tag design = new Tag();
        design.setKey("DESIGN");
        tags.add(design);

        Tag studio = new Tag();
        studio.setKey("STUDIO");
        tags.add(studio);

        Tag smart = new Tag();
        smart.setKey("SMART");
        tags.add(smart);

        Tag creative = new Tag();
        creative.setKey("CREATIVE");
        tags.add(creative);

        Tag tips = new Tag();
        tips.setKey("TIPS");
        tags.add(tips);

        Tag marketing = new Tag();
        marketing.setKey("MARKETING");
        tags.add(marketing);

        tagRepository.saveAll(tags);

        //Creation des categories de posts
        List<Category> categories = new ArrayList<>();

        Category covid = new Category();
        covid.setTitle("COVID 19");
        categories.add(covid);

        Category nba = new Category();
        nba.setTitle("NBA");
        categories.add(nba);

        Category meteo = new Category();
        meteo.setTitle("METEO");
        categories.add(meteo);

        Category foot = new Category();
        foot.setTitle("FOOTBALL");
        categories.add(foot);

        Category people = new Category();
        people.setTitle("PRESS PEOPLE");
        categories.add(people);

        Category tech = new Category();
        tech.setTitle("TECHNOLOGY");
        categories.add(tech);

        categoryRepository.saveAll(categories);

        //Creation des posts
        List<Post> posts = new ArrayList<>();

        Post post1= new Post();
        post1.setAuthor( randomUser(users) );
        post1.setCategories(categories.subList(1, 3));
        post1.setTags(tags.subList(0,7));
        post1.setBody("Le taux d???incidence semble se stabiliser, mais au-dessus du seuil d???alerte. La part du variant Delta est ?? interpr??ter avec prudence\n" +
                "Un ultimatum de sept jours. C???est le d??lai fix?? par le Premier ministre Jean Castex avant de d??cider, ou non, la poursuite de restrictions dans les Landes, notamment sur la question des ?? jauges ?? dans les lieux recevant du public. Mais aucun crit??re chiffr?? n???a ??t?? avanc?? par le gouvernement.");
        post1.setTitle("Covid-19 et variant Delta dans les Landes : concr??tement, o?? en est la situation????");
        posts.add(post1);

        Post post2= new Post();
        post2.setAuthor( randomUser(users) );
        post2.setCategories(categories.subList(2,4));
        post2.setTags(tags.subList(0,8));
        post2.setBody("Plus que jamais d??termin?? ?? porter les Bucks en grande finale, Giannis Antetokounmpo n???est pas l?? pour plaisanter dans ces playoffs. Il l???a rappel?? ce dimanche soir, avec un rapprochement sur un gros record appartenant ?? Shaquille O???Neal.\n" +
                "\n" +
                "Pour les Bucks, c???est s??rement l???ann??e ou jamais pour tenter de remporter ce titre NBA. Avec l?????limination de la concurrence ?? l???Ouest, et celle des Nets ?? l???Est, la franchise du Wisconsin poss??de une voie royale pour tenter de remporter la bague, et ainsi donner raison ?? Giannis Antetokounmpo, qui a d??cid?? de rester sur le long terme.\n" +
                "\n" +
                "Mais avant de penser au titre, il faut ??liminer les Hawks, qui ne sont pas l?? pour faciliter la t??che de Milwaukee. La franchise a m??me remport?? le premier match mais depuis, la mission s???est l??g??rement cors??e. Il faut dire que Giannis ne rigole pas.\n" +
                "\n" +
                "S??rement frustr?? d???avoir mal d??but?? cette finale de conf??rence, le Greek Freak s???est f??ch??. Il compile 33 points, 11 rebonds, 4 passes et 2 interceptions dans le succ??s des siens ce dimanche soir dans le Game 3 : 113-102. Voil?? que les hommes de Mike Bundenholzer reprennent le contr??le, mais ils doivent aussi remercier Khris Middleton.\n" +
                "\n" + "Giannis Antetokounmpo a eu son 9??me match avec au moins 30 points et 10 rebonds dans cette postseason, le plus gros total depuis Shaquille O???Neal en 2000 (13).");
        post2.setTitle("NBA ??? Giannis tout proche de battre un record vieux de 21 ans appartenant au Shaq !");
        posts.add(post2);

        Post post3 = new Post();
        post3.setAuthor(randomUser(users));
        post3.setBody("nternet est tomb?? fou amoureux des jumelles ?? Trueblue ?? apr??s que leur m??re a partag?? pour la premi??re fois des photos de Megan et Morgan Boyd sur Instagram. Stephanie Boyd a commenc?? ?? publier des photos de ses jumelles ?? l?????ge de quatre ans, les surnommant les jumelles ?? Trueblue ??. La beaut?? unique des jumelles a attir?? l???attention de plus de 166 000 utilisateurs d???Instagram. Leurs fans ne se lassent pas de ces deux jeunes beaut??s. Voici quelques-unes de leurs photos les plus populaires??? continuez ?? lire pour voir ?? quoi elles ressemblent aujourd???hui !\n" +
                "\n" +
                "Les jumelles sont n??es en juin 2011\n" +
                "Les jumelles Megan et Morgan Boyd sont n??es le 6 juin 2011. Ce fut le coup de foudre pour leur m??re, St??phanie, et elle a imm??diatement su qu???il y avait quelque chose de sp??cial chez ses filles. Les filles sont n??es avec de beaux yeux qui ont envout?? tous ceux qui croisaient leur regard. Stephanie ??tait ravie d???accueillir les filles dans ce monde et savait qu???elle adorerait ??tre la m??re de Megan et Morgan.");
        post3.setTitle("Les Jumelles ???Trueblue??? D??veloppent Un Nombre Impressionnant De Followers Sur Instagram");
        post3.setCategories(categories.subList(0,5));
        post3.setTags(tags.subList(1,8));
        posts.add(post3);

        Post post4 = new Post();
        post4.setAuthor(randomUser(users));
        post4.setCategories(categories.subList(0,3));
        post4.setTags(tags.subList(1, 6));
        post4.setTitle("FC BARCELONE - MERCATO : LE PSG A SIGN?? UN DERNIER COUP DE MA??TRE MAGISTRAL AVEC MESSI !\n");
        post4.setBody("Messi enchant?? de l'arriv??e de Wijnaldum\n" +
                "Le dirigeant br??silien savait en effet que Messi avait donn?? son feu vert avec un grand optimisme pour son arriv??e au FC Barcelone. Attirer au PSG le milieu international n??erlandais ??tait donc ?? ses yeux un argument solide de plus pour aimanter ?? La Pulga ?? dans la Ville Lumi??re.\n" +
                "\n" +
                "?? Messi ??tait enchant?? ?? l???id??e que le Bar??a boucle son arriv??e, a assur?? r??cemment son agent Humphry Nijman dans l?????mission ?? Here we go ?? relay??e en Espagne. Gini, lui, ??tait alors fier de pouvoir compter sur son soutien. ?? Le PSG et Leonardo sont pass??s par l?? entre temps...\n" +
                "\n");
        posts.add(post4);

        Post post5 = new Post();
        //post5.setAuthor(user2);
        post5.setCategories(categories.subList(1,5));
        post5.setTags(tags.subList(2,8));
        post5.setTitle("Orages, gr??le, vent : 11 d??partements en vigilance orange");
        post5.setBody("\"Une nouvelle vague orageuse attendue en d??but d'apr??s-midi\"\n" +
                "Selon le bulletin de M??t??o France publi?? ?? 10h, \"ce (lundi) matin la situation est assez calme dans la zone en vigilance orange. Quelques orages faibles et sporadiques s'y sont produits. L'??v??nement n'a pas encore d??but??\".\n" +
                "\n" +
                "\"Une nouvelle vague orageuse est attendue d??s le d??but d'apr??s-midi au nord-est du Massif Central. Les orages se propageront rapidement vers le nord. Pr??s des fronti??res suisses et allemandes jusqu???en milieu de nuit, il existe un risque d'orages violents avec des chutes de gr??le, de fortes rafales de vent (voisines de 100 km/h) et de fortes intensit??s de pr??cipitations (de l'ordre de 30 mm/h). L'activit?? orageuse diminuera nettement au cours de la nuit de lundi ?? mardi. La vigilance orange pourra alors ??tre lev??e\".");
        posts.add(post5);

        Post post6 = new Post();
        post6.setAuthor(randomUser(users));
        post6.setCategories(categories.subList(2,5));
        post6.setTags(tags.subList(0,5));
        post6.setBody("Microsoft exclut donc pas mal syst??mes bas??s sur des processeurs un peu anciens.\n" +
                "\n" +
                "Lorsque Microsoft a pr??sent?? officiellement Windows 11, la firme a indiqu?? que l???un des crit??res d?????ligibilit?? au nouvel OS ??tait la technologie TPM (Trusted Platform Module) 2.0. Malheureusement, ce pr??requis risque bien d???exclure bon nombre de PC DIY actuellement utilis??s. En effet, dans la liste des CPU pris en charge par Microsoft, ne figurent pas les Ryzen 1xxx ainsi que les Intel Core sortis avant ceux de 8e g??n??ration (Coffee Lake).");
        post6.setTitle("Windows 11 n??cessitera au moins un processeur Intel Core de 8e g??n??ration ou AMD Ryzen de 2e g??n??ration");
        posts.add(post6);

        //Creation des Comments
        List<Comment> comments = new ArrayList<>();

        Comment comment1 = new Comment();
        comment1.setAuthor(randomUser(users));
        comment1.setBody("Giannis is on fire - The Greak has to be great");
        comment1.setPost(post2);
        comments.add(comment1);

        Comment comment2 = new Comment();
        comment2.setAuthor(randomUser(users));
        comment2.setBody("C'est une opportunit?? et une belle .Oui il ne vient pas pour des cacahu??tes. Mais niveau transfert il est gratuit.");
        comment2.setPost(post4);
        comments.add(comment2);

        Comment comment3 = new Comment();
        comment3.setAuthor(randomUser(users));
        comment3.setBody("Avec Windows 11, Microsoft s'agrege a l'ecosysteme Android");
        comment3.setPost(post4);
        comments.add(comment3);

        postRepository.saveAll(posts);
        commentRepository.saveAll(comments);

        alreadySetup = true;
    }

    private User randomUser(List<User> users){
        // initializing random class
        Random random_method = new Random();
        int index = random_method.nextInt(users.size());
        return users.get(index);
    }
}