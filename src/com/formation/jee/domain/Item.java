package com.formation.jee.domain;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

 
@JsonTypeInfo(  
    use = JsonTypeInfo.Id.NAME,  
    include = JsonTypeInfo.As.PROPERTY,  
    property = "type")  
@JsonSubTypes({  
    @Type(value = Armor.class, name = "armor"),  
    @Type(value = Weapon.class, name = "weapon"),  
    @Type(value = Consumable.class, name = "consumable") })
public class Item {
	
}
