/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Profile;
import entities.RenameMe;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class RenameMeDTO {
    private int id;
    private String str1;
    private String str2;
    private List<ProfileDTO> profiles = new ArrayList<>();


    public RenameMeDTO(RenameMe rme) {
        if(rme.getId() != 0)
            this.id = rme.getId();
        this.str1 = rme.getDummyStr1();
        this.str2 = rme.getDummyStr2();
        rme.getProfileList().forEach(profile -> this.profiles.add(new ProfileDTO(profile)));
    }
    // TODO: Might need to do something about the userName!?
    public RenameMe getEntity() {
        RenameMe r = new RenameMe(this.str1, this.str2);
        this.profiles.forEach(profile -> r.addProfile(profile.getEntity()));
        return r;
    }
    public static List<RenameMeDTO> toList(List<RenameMe> rms) {
        return rms.stream().map(RenameMeDTO::new).collect(Collectors.toList());
    }



    public String getDummyStr1() {
        return str1;
    }

    public void setDummyStr1(String dummyStr1) {
        this.str1 = dummyStr1;
    }

    public String getDummyStr2() {
        return str2;
    }

    public void setDummyStr2(String dummyStr2) {
        this.str2 = dummyStr2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RenameMeDTO{" + "id=" + id + ", str1=" + str1 + ", str2=" + str2 + '}';
    }
    
    
    
    
    
    
}
