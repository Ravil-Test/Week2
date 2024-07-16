package ru.nurullin.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.nurullin.springcourse.models.Gun;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Neil Alishev
 */
@Component
public class GunDAO {
    private static int WEAPON_COUNT;
    private List<Gun> weapon;

    {
        weapon = new ArrayList<>();

        weapon.add(new Gun(++WEAPON_COUNT, "AK-74", "carbine", 30));
        weapon.add(new Gun(++WEAPON_COUNT, "M4", "carbine", 30));
        weapon.add(new Gun(++WEAPON_COUNT, "M14", "rifle", 20));
        weapon.add(new Gun(++WEAPON_COUNT, "SKS", "rifle", 10));
    }

    public List<Gun> index() {
        return weapon;
    }

    public Gun show(int id) {
        return weapon.stream().filter(gun -> gun.getId() == id).findAny().orElse(null);
    }

    public void save(Gun gun) {
        gun.setId(++WEAPON_COUNT);
        weapon.add(gun);
    }

    public void update(int id, Gun updatedGun) {
        Gun gunToBeUpdated = show(id);

        gunToBeUpdated.setName(updatedGun.getName());
        gunToBeUpdated.setType(updatedGun.getType());
        gunToBeUpdated.setCapacity(updatedGun.getCapacity());
    }

    public void delete(int id) {
        weapon.removeIf(p -> p.getId() == id);
    }
}