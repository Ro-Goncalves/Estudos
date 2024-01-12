package br.com.mypets.infrastructure.ports;

import br.com.mypets.infrastructure.model.ClientRespose;
import br.com.mypets.infrastructure.model.GetRequest;
import br.com.mypets.infrastructure.model.PostRequest;

public interface Client {
    ClientRespose handle(GetRequest getRequest);
    ClientRespose handle(PostRequest postRequest);
}
