package com.perfect.team.service.request;

import com.perfect.team.service.request.base.AuthRequest;

public class IdRequest extends AuthRequest {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "IdRequest{" +
                "id=" + id +
                "} " + super.toString();
    }
}
