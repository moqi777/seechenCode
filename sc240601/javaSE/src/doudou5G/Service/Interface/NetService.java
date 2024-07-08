package doudou5G.Service.Interface;

import doudou5G.entity.ConsumInfo;
import doudou5G.entity.MobileCard;
import doudou5G.util.RegSerializable;
import doudou5G.util.SelectMobileCardToCardNumber;

public interface NetService {
    boolean netPlay(int flow,String cardNumber);
}
