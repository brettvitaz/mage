
package mage.abilities.condition.common;

import mage.abilities.Ability;
import mage.abilities.condition.Condition;
import mage.constants.SubType;
import mage.filter.FilterPermanent;
import mage.filter.common.FilterCreaturePermanent;
import mage.filter.predicate.mageobject.SubtypePredicate;
import mage.game.Game;
import mage.game.permanent.Permanent;

/**
 *
 * @author fireshoes
 */
public class EnchantedCreatureSubtypeCondition implements Condition {

    private final FilterPermanent filter = new FilterCreaturePermanent();

    public EnchantedCreatureSubtypeCondition(SubType string) {
        filter.add(new SubtypePredicate(string));
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Permanent enchantment = game.getPermanent(source.getSourceId());
        if (enchantment != null) {
            Permanent creature = game.getPermanent(enchantment.getAttachedTo());
            if (creature != null) {
                if (filter.match(creature, source.getSourceId(), enchantment.getControllerId(), game)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return filter.getMessage();
    }

}
