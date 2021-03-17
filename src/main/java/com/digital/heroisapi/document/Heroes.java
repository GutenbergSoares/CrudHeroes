package com.digital.heroisapi.document;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import org.springframework.data.annotation.Id;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@DynamoDBTable(tableName = "Heroes_Table")
public class Heroes {


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniverso() {
        return universo;
    }

    public void setUniverso(String universo) {
        this.universo = universo;
    }

    public int getFilmes() {
        return filmes;
    }

    public void setFilmes(int filmes) {
        this.filmes = filmes;
    }

    @Id
    @DynamoDBHashKey(attributeName = "id")
    private String id;

    @DynamoDBAttribute(attributeName = "name")
    private String name;

    @DynamoDBAttribute(attributeName = "universo")
    private String universo;

    @DynamoDBAttribute(attributeName = "filme")
    private int filmes;

    public Heroes(String id, String name, String universo, int filmes){
        this.id=id;
        this.name=name;
        this.universo=universo;
        this.filmes = filmes;
    }
}
