package com.gcnc.sskbe.main;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MetaDataRequest {
    String data;
    List<Long> pattern;
}
