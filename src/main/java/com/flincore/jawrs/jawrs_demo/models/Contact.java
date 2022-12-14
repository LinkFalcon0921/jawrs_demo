package com.flincore.jawrs.jawrs_demo.models;

import com.flincore.jawrs.jawrs_demo.embebbed.PhoneNumber;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "contacts")
@Entity
@Setter
@Getter
@NoArgsConstructor
public class Contact {

    @Id
    private Long id;

    @Column(name = "icon_image")
    private byte[] imageRef;

    private String alias;

    @Embedded
    private PhoneNumber number;

    @ManyToOne
    private User owner;

}
