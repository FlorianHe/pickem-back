package com.pickemback.pickemback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pickemback.pickemback.entity.Champion;
import com.pickemback.pickemback.entity.Drake;
import com.pickemback.pickemback.entity.Player;
import com.pickemback.pickemback.entity.Team;
import com.pickemback.pickemback.repository.ChampionRepository;
import com.pickemback.pickemback.repository.DrakeRepository;
import com.pickemback.pickemback.repository.PlayerRepository;
import com.pickemback.pickemback.repository.TeamRepository;

import jakarta.annotation.PostConstruct;

@Component
public class DbInit {
    @Autowired
    private DrakeRepository drakeRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private ChampionRepository championRepository;

    @PostConstruct
    private void postConstruct() {
        if (drakeRepository.count() == 0) {
            List<Drake> drakes = new ArrayList<>();
            drakes.add(new Drake("Infernal"));
            drakes.add(new Drake("Mountain"));
            drakes.add(new Drake("Ocean"));
            drakes.add(new Drake("Hextech"));
            drakes.add(new Drake("Chemtech"));
            drakes.add(new Drake("Cloud"));

            for (Drake drake : drakes) {
                drake = drakeRepository.save(drake);
            }
        }
        if (teamRepository.count() == 0) {
            List<Team> teams = new ArrayList<>();
            teams.add(new Team("Gen.G"));
            teams.add(new Team("T1"));
            teams.add(new Team("KT Rolster"));
            teams.add(new Team("Dplus KIA"));
            teams.add(new Team("JD Gaming"));
            teams.add(new Team("Bilibili Gaming"));
            teams.add(new Team("LNG Esports"));
            teams.add(new Team("Weibo Gaming"));
            teams.add(new Team("G2 Esports"));
            teams.add(new Team("Fnatic"));
            teams.add(new Team("MAD Lions"));
            teams.add(new Team("NRG"));
            teams.add(new Team("Cloud9"));
            teams.add(new Team("Team Liquid"));
            teams.add(new Team("PSG Talon"));
            teams.add(new Team("CTBC Flying_Oyster"));
            teams.add(new Team("GAM Esports"));
            teams.add(new Team("Team Whales"));
            teams.add(new Team("DetonatioN FocusMe"));
            teams.add(new Team("LOUD"));
            teams.add(new Team("Movistar R7"));
            teams.add(new Team("Team BDS"));

            for (Team team : teams) {
                team = teamRepository.save(team);
            }
        }
        if (playerRepository.count() == 0) {
            List<Team> teams = teamRepository.findAll();
            Map<String, List<Player>> teamPlayersMap = new HashMap<>();
            teamPlayersMap.put("Gen.G", Arrays.asList(
                new Player("Doran", "Top"),
                new Player("Peanut", "Jungle"),
                new Player("Chovy", "Mid"),
                new Player("Peyz", "ADC"),
                new Player("Delight", "Support")
            ));
            teamPlayersMap.put("T1", Arrays.asList(
                new Player("Zeus", "Top"),
                new Player("Oner", "Jungle"),
                new Player("Faker", "Mid"),
                new Player("Gumayusi", "ADC"),
                new Player("Keria", "Support")
            ));
            teamPlayersMap.put("KT Rolster", Arrays.asList(
                new Player("Kiin", "Top"),
                new Player("Cuzz", "Jungle"),
                new Player("Bdd", "Mid"),
                new Player("Aiming", "ADC"),
                new Player("Lehends", "Support")
            ));
            teamPlayersMap.put("Dplus KIA", Arrays.asList(
                new Player("Canna", "Top"),
                new Player("Canyon", "Jungle"),
                new Player("ShowMaker", "Mid"),
                new Player("Deft", "ADC"),
                new Player("Bible", "Support")
            ));
            teamPlayersMap.put("JD Gaming", Arrays.asList(
                new Player("369", "Top"),
                new Player("Kanavi", "Jungle"),
                new Player("knight", "Mid"),
                new Player("Ruler", "ADC"),
                new Player("MISSING", "Support")
            ));
            teamPlayersMap.put("Bilibili Gaming", Arrays.asList(
                new Player("Bin", "Top"),
                new Player("Xun", "Jungle"),
                new Player("Yagao", "Mid"),
                new Player("Elk", "ADC"),
                new Player("ON", "Support")
            ));
            teamPlayersMap.put("LNG Esports", Arrays.asList(
                new Player("Zika", "Top"),
                new Player("Tarzan", "Jungle"),
                new Player("Scout", "Mid"),
                new Player("GALA", "ADC"),
                new Player("Hang", "Support")
            ));
            teamPlayersMap.put("Weibo Gaming", Arrays.asList(
                new Player("TheShy", "Top"),
                new Player("Weiwei", "Jungle"),
                new Player("Xiaohu", "Mid"),
                new Player("Light", "ADC"),
                new Player("Crisp", "Support")
            ));
            teamPlayersMap.put("G2 Esports", Arrays.asList(
                new Player("BrokenBlade", "Top"),
                new Player("Yike", "Jungle"),
                new Player("Caps", "Mid"),
                new Player("Hans Sama", "ADC"),
                new Player("Mikyx", "Support")
            ));
            teamPlayersMap.put("Fnatic", Arrays.asList(
                new Player("Oscarinin", "Top"),
                new Player("Razork", "Jungle"),
                new Player("Humanoid", "Mid"),
                new Player("Noah", "ADC"),
                new Player("Trymbi", "Support")
            ));
            teamPlayersMap.put("MAD Lions", Arrays.asList(
                new Player("Chasy", "Top"),
                new Player("Elyoya", "Jungle"),
                new Player("Nisqy", "Mid"),
                new Player("Carzzy", "ADC"),
                new Player("Hylissang", "Support")
            ));
            teamPlayersMap.put("NRG", Arrays.asList(
                new Player("Dhokla", "Top"),
                new Player("Contractz", "Jungle"),
                new Player("Palafox", "Mid"),
                new Player("FBI", "ADC"),
                new Player("Ignar", "Support")
            ));
            teamPlayersMap.put("Cloud9", Arrays.asList(
                new Player("Fudge", "Top"),
                new Player("Blaber", "Jungle"),
                new Player("EMENES", "Mid"),
                new Player("Berserker", "ADC"),
                new Player("Zven", "Support")
            ));
            teamPlayersMap.put("Team Liquid", Arrays.asList(
                new Player("Summit", "Top"),
                new Player("Pyosik", "Jungle"),
                new Player("APA", "Mid"),
                new Player("Yeon", "ADC"),
                new Player("CoreJJ", "Support")
            ));
            teamPlayersMap.put("PSG Talon", Arrays.asList(
                new Player("Azhi", "Top"),
                new Player("Junjia", "Jungle"),
                new Player("Maple", "Mid"),
                new Player("Wako", "ADC"),
                new Player("Woody", "Support")
            ));
            teamPlayersMap.put("CTBC Flying_Oyster", Arrays.asList(
                new Player("Rest", "Top"),
                new Player("Gemini", "Jungle"),
                new Player("JimieN", "Mid"),
                new Player("Shunn", "ADC"),
                new Player("ShiauC", "Support")
            ));
            teamPlayersMap.put("GAM Esports", Arrays.asList(
                new Player("Kiaya", "Top"),
                new Player("Levi", "Jungle"),
                new Player("Kati", "Mid"),
                new Player("Slayder", "ADC"),
                new Player("Palette", "Support")
            ));
            teamPlayersMap.put("Team Whales", Arrays.asList(
                new Player("Sparda", "Top"),
                new Player("BeanJ", "Jungle"),
                new Player("Glory", "Mid"),
                new Player("Artemis", "ADC"),
                new Player("Bie", "Support")
            ));
            teamPlayersMap.put("DetonatioN FocusMe", Arrays.asList(
                new Player("ApaMen", "Top"),
                new Player("Steal", "Jungle"),
                new Player("Aria", "Mid"),
                new Player("Yutapon", "ADC"),
                new Player("Harp", "Support")
            ));
            teamPlayersMap.put("LOUD", Arrays.asList(
                new Player("Robo", "Top"),
                new Player("Croc", "Jungle"),
                new Player("Tinowns", "Mid"),
                new Player("Route", "ADC"),
                new Player("Ceos", "Support")
            ));
            teamPlayersMap.put("Movistar R7", Arrays.asList(
                new Player("Bong", "Top"),
                new Player("Oddie", "Jungle"),
                new Player("Mireu", "Mid"),
                new Player("Ceo", "ADC"),
                new Player("Lyonz", "Support")
            ));
            teamPlayersMap.put("Team BDS", Arrays.asList(
                new Player("Adam", "Top"),
                new Player("Sheo", "Jungle"),
                new Player("nuc", "Mid"),
                new Player("Crownie", "ADC"),
                new Player("Labrov", "Support")
            ));
            for (Team team : teams) {
                String teamName = team.getName();
                if (teamPlayersMap.containsKey(teamName)) {
                    List<Player> players = teamPlayersMap.get(teamName);
                    for (Player player : players) {
                        player.setTeam(team);
                        player = playerRepository.save(player);
                    }
                }
            }
        }
        if (championRepository.count() == 0) {
                List<Champion> champions = new ArrayList<>();
                champions.add(new Champion("AATROX"));
                champions.add(new Champion("AHRI"));
                champions.add(new Champion("AKALI"));
                champions.add(new Champion("AKSHAN"));
                champions.add(new Champion("ALISTAR"));
                champions.add(new Champion("AMUMU"));
                champions.add(new Champion("ANIVIA"));
                champions.add(new Champion("ANNIE"));
                champions.add(new Champion("APHELIOS"));
                champions.add(new Champion("ASHE"));
                champions.add(new Champion("AURELION SOL"));
                champions.add(new Champion("AZIR"));
                champions.add(new Champion("BARD"));
                champions.add(new Champion("BEL'VETH"));
                champions.add(new Champion("BLITZCRANK"));
                champions.add(new Champion("BRAND"));
                champions.add(new Champion("BRAUM"));
                champions.add(new Champion("BRIAR"));
                champions.add(new Champion("CAITLYN"));
                champions.add(new Champion("CAMILLE"));
                champions.add(new Champion("CASSIOPEIA"));
                champions.add(new Champion("CHO'GATH"));
                champions.add(new Champion("CORKI"));
                champions.add(new Champion("DARIUS"));
                champions.add(new Champion("DIANA"));
                champions.add(new Champion("DR. MUNDO"));
                champions.add(new Champion("DRAVEN"));
                champions.add(new Champion("EKKO"));
                champions.add(new Champion("ELISE"));
                champions.add(new Champion("EVELYNN"));
                champions.add(new Champion("EZREAL"));
                champions.add(new Champion("FIDDLESTICKS"));
                champions.add(new Champion("FIORA"));
                champions.add(new Champion("FIZZ"));
                champions.add(new Champion("GALIO"));
                champions.add(new Champion("GANGPLANK"));
                champions.add(new Champion("GAREN"));
                champions.add(new Champion("GNAR"));
                champions.add(new Champion("GRAGAS"));
                champions.add(new Champion("GRAVES"));
                champions.add(new Champion("GWEN"));
                champions.add(new Champion("HECARIM"));
                champions.add(new Champion("HEIMERDINGER"));
                champions.add(new Champion("ILLAOI"));
                champions.add(new Champion("IRELIA"));
                champions.add(new Champion("IVERN"));
                champions.add(new Champion("JANNA"));
                champions.add(new Champion("JARVAN IV"));
                champions.add(new Champion("JAX"));
                champions.add(new Champion("JAYCE"));
                champions.add(new Champion("JHIN"));
                champions.add(new Champion("JINX"));
                champions.add(new Champion("K'SANTE"));
                champions.add(new Champion("KAI'SA"));
                champions.add(new Champion("KALISTA"));
                champions.add(new Champion("KARMA"));
                champions.add(new Champion("KARTHUS"));
                champions.add(new Champion("KASSADIN"));
                champions.add(new Champion("KATARINA"));
                champions.add(new Champion("KAYLE"));
                champions.add(new Champion("KAYN"));
                champions.add(new Champion("KENNEN"));
                champions.add(new Champion("KHA'ZIX"));
                champions.add(new Champion("KINDRED"));
                champions.add(new Champion("KLED"));
                champions.add(new Champion("KOG'MAW"));
                champions.add(new Champion("LEBLANC"));
                champions.add(new Champion("LEE SIN"));
                champions.add(new Champion("LEONA"));
                champions.add(new Champion("LILLIA"));
                champions.add(new Champion("LISSANDRA"));
                champions.add(new Champion("LUCIAN"));
                champions.add(new Champion("LULU"));
                champions.add(new Champion("LUX"));
                champions.add(new Champion("MALPHITE"));
                champions.add(new Champion("MALZAHAR"));
                champions.add(new Champion("MAOKAI"));
                champions.add(new Champion("MASTER YI"));
                champions.add(new Champion("MILIO"));
                champions.add(new Champion("MISS FORTUNE"));
                champions.add(new Champion("MORDEKAISER"));
                champions.add(new Champion("MORGANA"));
                champions.add(new Champion("NAAFIRI"));
                champions.add(new Champion("NAMI"));
                champions.add(new Champion("NASUS"));
                champions.add(new Champion("NAUTILUS"));
                champions.add(new Champion("NEEKO"));
                champions.add(new Champion("NIDALEE"));
                champions.add(new Champion("NILAH"));
                champions.add(new Champion("NOCTURNE"));
                champions.add(new Champion("NUNU & WILLUMP"));
                champions.add(new Champion("OLAF"));
                champions.add(new Champion("ORIANNA"));
                champions.add(new Champion("ORNN"));
                champions.add(new Champion("PANTHEON"));
                champions.add(new Champion("POPPY"));
                champions.add(new Champion("PYKE"));
                champions.add(new Champion("QIYANA"));
                champions.add(new Champion("QUINN"));
                champions.add(new Champion("RAKAN"));
                champions.add(new Champion("RAMMUS"));
                champions.add(new Champion("REK'SAI"));
                champions.add(new Champion("RELL"));
                champions.add(new Champion("RENATA GLASC"));
                champions.add(new Champion("RENEKTON"));
                champions.add(new Champion("RENGAR"));
                champions.add(new Champion("RIVEN"));
                champions.add(new Champion("RUMBLE"));
                champions.add(new Champion("RYZE"));
                champions.add(new Champion("SAMIRA"));
                champions.add(new Champion("SEJUANI"));
                champions.add(new Champion("SENNA"));
                champions.add(new Champion("SERAPHINE"));
                champions.add(new Champion("SETT"));
                champions.add(new Champion("SHACO"));
                champions.add(new Champion("SHEN"));
                champions.add(new Champion("SHYVANA"));
                champions.add(new Champion("SINGED"));
                champions.add(new Champion("SION"));
                champions.add(new Champion("SIVIR"));
                champions.add(new Champion("SKARNER"));
                champions.add(new Champion("SONA"));
                champions.add(new Champion("SORAKA"));
                champions.add(new Champion("SWAIN"));
                champions.add(new Champion("SYLAS"));
                champions.add(new Champion("SYNDRA"));
                champions.add(new Champion("TAHM KENCH"));
                champions.add(new Champion("TALIYAH"));
                champions.add(new Champion("TALON"));
                champions.add(new Champion("TARIC"));
                champions.add(new Champion("TEEMO"));
                champions.add(new Champion("THRESH"));
                champions.add(new Champion("TRISTANA"));
                champions.add(new Champion("TRUNDLE"));
                champions.add(new Champion("TRYNDAMERE"));
                champions.add(new Champion("TWISTED FATE"));
                champions.add(new Champion("TWITCH"));
                champions.add(new Champion("UDYR"));
                champions.add(new Champion("URGOT"));
                champions.add(new Champion("VARUS"));
                champions.add(new Champion("VAYNE"));
                champions.add(new Champion("VEIGAR"));
                champions.add(new Champion("VEL'KOZ"));
                champions.add(new Champion("VEX"));
                champions.add(new Champion("VI"));
                champions.add(new Champion("VIEGO"));
                champions.add(new Champion("VIKTOR"));
                champions.add(new Champion("VLADIMIR"));
                champions.add(new Champion("VOLIBEAR"));
                champions.add(new Champion("WARWICK"));
                champions.add(new Champion("WUKONG"));
                champions.add(new Champion("XAYAH"));
                champions.add(new Champion("XERATH"));
                champions.add(new Champion("XIN ZHAO"));
                champions.add(new Champion("YASUO"));
                champions.add(new Champion("YONE"));
                champions.add(new Champion("YORICK"));
                champions.add(new Champion("YUUMI"));
                champions.add(new Champion("ZAC"));
                champions.add(new Champion("ZED"));
                champions.add(new Champion("ZERI"));
                champions.add(new Champion("ZIGGS"));
                champions.add(new Champion("ZILEAN"));
                champions.add(new Champion("ZOE"));
                champions.add(new Champion("ZYRA"));
                for (Champion champion : champions) {
                    champion = championRepository.save(champion);
                }
                

            }
    }
}
