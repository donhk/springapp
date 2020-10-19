package dev.donhk.controller;

import dev.donhk.pojo.ButtonData;
import dev.donhk.pojo.Stats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FearController {


    @Autowired
    private Connection dataSource;

    @GetMapping("/")
    public String home(@RequestParam(name = "name", required = false, defaultValue = ":3") String name, Model model) {
        model.addAttribute("name", name);
        return "page";
    }

    @GetMapping("/stats")
    @ResponseBody
    public List<Stats> sayHello() throws Exception {
        final String countq = "select count(1) hits,ip from button_data group by ip";
        final PreparedStatement ps2 = dataSource.prepareStatement(countq);
        final ResultSet rs = ps2.executeQuery();
        final List<Stats> hits = new ArrayList<>();
        while (rs.next()) {
            hits.add(new Stats(rs.getLong("hits"), rs.getString("ip")));
        }
        return hits;
    }

    @PostMapping(path = "/log", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<String> logdata(@RequestBody ButtonData member) throws Exception {
        final String sql1 = "insert into button_data (ip) values (?)";
        final PreparedStatement ps1 = dataSource.prepareStatement(sql1);
        ps1.setString(1, member.getIp());
        ps1.executeUpdate();
        return new ResponseEntity<>("{\"message\":\"got it!\"}", HttpStatus.OK);
    }

}
