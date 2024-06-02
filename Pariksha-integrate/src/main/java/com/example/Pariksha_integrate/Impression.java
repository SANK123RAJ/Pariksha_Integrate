package com.example.Pariksha_integrate;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "impressions")
public class Impression {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long impressionId;

    private String eventtype;
    private String togglename;
    private Boolean togglestate;
    private String context;
    private String identifier;

    @Column(name = "createdat", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdat;

    // Getters and Setters

    public Long getImpressionId() {
        return impressionId;
    }

    public void setImpressionId(Long impressionId) {
        this.impressionId = impressionId;
    }

    public String getEventtype() {
        return eventtype;
    }

    public void setEventtype(String eventtype) {
        this.eventtype = eventtype;
    }

    public String getTogglename() {
        return togglename;
    }

    public void setTogglename(String togglename) {
        this.togglename = togglename;
    }

    public Boolean getTogglestate() {
        return togglestate;
    }

    public void setTogglestate(Boolean togglestate) {
        this.togglestate = togglestate;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public LocalDateTime getCreatedat() {
        return createdat;
    }

    public void setCreatedat(LocalDateTime createdat) {
        this.createdat = createdat;
    }
}
