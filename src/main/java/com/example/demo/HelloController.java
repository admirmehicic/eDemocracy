package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelExtensionsKt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

@Controller
public class HelloController {

    @GetMapping("/login")
    public String login(@RequestParam String email, @RequestParam String pass, Model model) {


        String url = "jdbc:mysql://localhost:3306/baza";
        String user = "root";
        String passBaza = "admir";


        String passKorisnik = "";

        String sql = "SELECT lozinka FROM korisnici WHERE emailAdresa = ?";

        try (Connection connection = DriverManager.getConnection(url, user, passBaza)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);


            ResultSet resultSet = preparedStatement.executeQuery();


            if(email.equals("admin@admin.ba") && pass.equals("admin")) {
                return "adminPristup";
            } else  if (resultSet.next()) {

                passKorisnik = resultSet.getString("lozinka");


                resultSet.close();
                preparedStatement.close();
                out.println("uspjeh");

                if (passKorisnik.equals(pass)) {


                    return "success";

                }



            }




        } catch (SQLException e) {
            System.err.println("Error connecting to the MySQL server: " + e.getMessage());
        }
        return "registracija";
    }

    @GetMapping("/dig")
    public String dig(){
        return "digitalno";
    }

    @GetMapping("/kreiranje")
    public String kreiranje(){
        return "kreiranje";}

    @GetMapping("/pristup")
    public String pristup(){
        return "pristup";
    }

    @GetMapping("/prikaz")
    public String prikaz(){
        return "prikaz";
    }

    @GetMapping("/postavke")    public String postavke(){
        return "postavke";
    }

    @GetMapping("/registrovanje")
    public String registrovanje (){
        return "registracija";
    }

    @GetMapping("/pregledPrivatnih")
    public String pregledPr(){
        return "pregledPrivatnih";
    }

    @PostMapping("/obrada")
    public String obradaReg(@RequestParam String ime,
                            @RequestParam String prezime,
                            @RequestParam String jmbg,
                            @RequestParam String datum,
                            @RequestParam String email2,
                            @RequestParam String password,
                            @RequestParam String broj,
                            @RequestParam String adresa,
                            @RequestParam String kanton,
                            @RequestParam String grad){

        String url = "jdbc:mysql://localhost:3306/baza";
        String user = "root";
        String passBaza = "admir";



        String sql = "INSERT INTO korisnici (jmbg, datumRodenja, ime, prezime, adresa, brojTelefona, emailAdresa, lozinka, kanton, grad) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, user, passBaza)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, jmbg);
            preparedStatement.setString(2, datum);
            preparedStatement.setString(3, ime);
            preparedStatement.setString(4, prezime);
            preparedStatement.setString(5, adresa);
            preparedStatement.setString(6, broj);
            preparedStatement.setString(7, email2);
            preparedStatement.setString(8, password);
            preparedStatement.setString(9, kanton);
            preparedStatement.setString(10, grad);

            out.println("Korisnik sa ID " + jmbg + " je uspješno unesena u bazu.");


            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                out.println("Data inserted successfully!");
            } else {
                out.println("Failed to insert data.");
            }


        } catch (SQLException e) {
            System.err.println("Error connecting to the MySQL server: " + e.getMessage());
        }
        return "login";


    }

    @GetMapping("/prijavaObrada")
    public String prijavaObrada(@RequestParam String email, @RequestParam String password, Model model){
        String url = "jdbc:mysql://localhost:3306/baza";
        String user = "root";
        String passBaza = "admir";


        String passKorisnik = "";

        String sql = "SELECT lozinka FROM korisnici WHERE emailAdresa = ?";

        try (Connection connection = DriverManager.getConnection(url, user, passBaza)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);


            ResultSet resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {

                passKorisnik = resultSet.getString("lozinka");


                resultSet.close();
                preparedStatement.close();
                out.println("uspjeh");

                if (passKorisnik.equals(password)) {

                    return "success";

                }

            }


        } catch (SQLException e) {
            System.err.println("Error connecting to the MySQL server: " + e.getMessage());
        }
        return "success";
    }

    @PostMapping("/digitalnoPotpisivanje")
    public String digitalnoPotpisvianje(@RequestParam String naziv, @RequestParam int a, @RequestParam int kod){

        String url = "jdbc:mysql://localhost:3306/baza";
        String user = "root";
        String passBaza = "admir";



        String sql = "INSERT INTO digitalnoPotpisivanje (tip, filename, kod) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, user, passBaza)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, a);
            preparedStatement.setString(2, naziv);
            preparedStatement.setInt(3, kod);


            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                out.println("Data inserted successfully!");
            } else {
                out.println("Failed to insert data.");
            }


        } catch (SQLException e) {
            System.err.println("Error connecting to the MySQL server: " + e.getMessage());
        }
        return "success";


    }

    @PostMapping("/kreiranje")
    public String kreiranjeZahtjeva(@RequestParam int a, @RequestParam String svrha, @RequestParam int kod){

        String url = "jdbc:mysql://localhost:3306/baza";
        String user = "root";
        String passBaza = "admir";



        String sql = "INSERT INTO zahtjevi (vrsta, svrha, kod) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, user, passBaza)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, a);
            preparedStatement.setString(2, svrha);
            preparedStatement.setInt(3, kod);


            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                out.println("Data inserted successfully!");
            } else {
                out.println("Failed to insert data.");
            }


        } catch (SQLException e) {
            System.err.println("Error connecting to the MySQL server: " + e.getMessage());
        }
        return "success";


    }
    @PostMapping("/unosUposlenika")
    public String unosUposlenika(@RequestParam String ime,
                            @RequestParam String prezime,
                            @RequestParam String jmbg,
                            @RequestParam String datum,
                            @RequestParam String email2,
                            @RequestParam String password,
                            @RequestParam String broj,
                            @RequestParam int osnovica,
                            @RequestParam String adresa,
                            @RequestParam String kanton,
                            @RequestParam String grad){

        String url = "jdbc:mysql://localhost:3306/baza";
        String user = "root";
        String passBaza = "admir";



        String sql = "INSERT INTO uposlenici (jmbg, datumRodenja, ime, prezime, adresa, brojTelefona, osnovica,  emailAdresa, lozinka, kanton, grad) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, user, passBaza)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, jmbg);
            preparedStatement.setString(2, datum);
            preparedStatement.setString(3, ime);
            preparedStatement.setString(4, prezime);
            preparedStatement.setString(5, adresa);
            preparedStatement.setString(6, broj);
            preparedStatement.setInt(7, osnovica);
            preparedStatement.setString(8, email2);
            preparedStatement.setString(9, password);
            preparedStatement.setString(10, kanton);
            preparedStatement.setString(11, grad);

            out.println("Korisnik sa ID " + jmbg + " je uspješno unesena u bazu.");


            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                out.println("Data inserted successfully!");
            } else {
                out.println("Failed to insert data.");
            }


        } catch (SQLException e) {
            System.err.println("Error connecting to the MySQL server: " + e.getMessage());
        }
        return "login";


    }

    @GetMapping("/pregledKorisnika")
    public String pregledKorisnika(Model model){
        String url = "jdbc:mysql://localhost:3306/baza";
        String user = "root";
        String password = "admir";


        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            out.println("Connected to the MySQL server.");
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM korisnici";
            ResultSet resultSet = statement.executeQuery(query);

            List <String> nizJMBG = new ArrayList<>();
            List <String> nizDatum = new ArrayList<>();
            List<String> nizIme = new ArrayList<>();
            List<String> nizPrezime = new ArrayList<>();
            List <String> nizAdresa = new ArrayList<>();
            List <String> nizBroj = new ArrayList<>();
            List <String> nizEmail = new ArrayList<>();
            List<String> nizLozinka = new ArrayList<>();
            List<String> nizKanton = new ArrayList<>();
            List<String> nizGrad = new ArrayList<>();


            while(resultSet.next()){
                String jmbg = resultSet.getString("jmbg");
                String datum = resultSet.getString("datumRodenja");
                String ime = resultSet.getString("ime");
                String prezime = resultSet.getString("prezime");
                String adresa = resultSet.getString("adresa");
                String broj = resultSet.getString("brojTelefona");
                String email = resultSet.getString("emailAdresa");
                String lozinka = resultSet.getString("lozinka");
                String kanton = resultSet.getString("kanton");



                nizJMBG.add(jmbg);
                nizDatum.add(datum);
                nizIme.add(ime);
                nizPrezime.add(prezime);
                nizAdresa.add(adresa);
                nizBroj.add(broj);
                nizEmail.add(email);
                nizLozinka.add(lozinka);
                nizKanton.add(kanton);
            }


            model.addAttribute("nizJMBG", nizJMBG);
            model.addAttribute("nizDatum", nizDatum);
            model.addAttribute("nizIme", nizIme);
            model.addAttribute("nizPrezime", nizPrezime);
            model.addAttribute("nizAdresa", nizAdresa);
            model.addAttribute("nizBroj", nizBroj);
            model.addAttribute("nizEmail", nizEmail);
            model.addAttribute("nizLozinka", nizLozinka);
            model.addAttribute("nizKanton", nizKanton);


        } catch (SQLException e) {
            System.err.println("Error connecting to the MySQL server: " + e.getMessage());
        }

        return "pregledKorisnika";
    }

    @GetMapping("/pregledUposlenika")
    public String pregledUposlenika(Model model){
        String url = "jdbc:mysql://localhost:3306/baza";
        String user = "root";
        String password = "admir";


        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            out.println("Connected to the MySQL server.");
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM uposlenici";
            ResultSet resultSet = statement.executeQuery(query);

            List <String> nizJMBG = new ArrayList<>();
            List <String> nizDatum = new ArrayList<>();
            List<String> nizIme = new ArrayList<>();
            List<String> nizPrezime = new ArrayList<>();
            List <String> nizAdresa = new ArrayList<>();
            List <String> nizBroj = new ArrayList<>();
            List <String> nizEmail = new ArrayList<>();
            List<String> nizLozinka = new ArrayList<>();
            List<String> nizKanton = new ArrayList<>();
            List<Integer> nizOsnovica = new ArrayList<>();


            while(resultSet.next()){
                String jmbg = resultSet.getString("jmbg");
                String datum = resultSet.getString("datumRodenja");
                String ime = resultSet.getString("ime");
                String prezime = resultSet.getString("prezime");
                String adresa = resultSet.getString("adresa");
                String broj = resultSet.getString("brojTelefona");
                String email = resultSet.getString("emailAdresa");
                String lozinka = resultSet.getString("lozinka");
                String kanton = resultSet.getString("kanton");
                int osnovica = resultSet.getInt("osnovica");



                nizJMBG.add(jmbg);
                nizDatum.add(datum);
                nizIme.add(ime);
                nizPrezime.add(prezime);
                nizAdresa.add(adresa);
                nizBroj.add(broj);
                nizEmail.add(email);
                nizLozinka.add(lozinka);
                nizKanton.add(kanton);
                nizOsnovica.add(osnovica);
            }


            model.addAttribute("nizJMBG", nizJMBG);
            model.addAttribute("nizDatum", nizDatum);
            model.addAttribute("nizIme", nizIme);
            model.addAttribute("nizPrezime", nizPrezime);
            model.addAttribute("nizAdresa", nizAdresa);
            model.addAttribute("nizBroj", nizBroj);
            model.addAttribute("nizEmail", nizEmail);
            model.addAttribute("nizLozinka", nizLozinka);
            model.addAttribute("nizKanton", nizKanton); 
            model.addAttribute("nizOsnovica", nizOsnovica);


        } catch (SQLException e) {
            System.err.println("Error connecting to the MySQL server: " + e.getMessage());
        }

        return "pregledKorisnika";
    }




}






