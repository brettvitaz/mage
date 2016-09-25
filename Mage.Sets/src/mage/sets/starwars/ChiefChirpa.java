/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */
package mage.sets.starwars;

import java.util.UUID;
import mage.MageInt;
import mage.ObjectColor;
import mage.abilities.Ability;
import mage.abilities.common.BecomesMonstrousSourceTriggeredAbility;
import mage.abilities.common.DiesCreatureTriggeredAbility;
import mage.abilities.effects.common.CreateTokenEffect;
import mage.abilities.effects.common.counter.AddCountersTargetEffect;
import mage.abilities.keyword.MonstrosityAbility;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Rarity;
import mage.constants.TargetController;
import mage.counters.CounterType;
import mage.filter.common.FilterControlledCreaturePermanent;
import mage.filter.common.FilterCreaturePermanent;
import mage.filter.predicate.mageobject.ColorPredicate;
import mage.filter.predicate.mageobject.SubtypePredicate;
import mage.filter.predicate.permanent.AnotherPredicate;
import mage.filter.predicate.permanent.ControllerPredicate;
import mage.game.permanent.token.EwokToken;
import mage.target.common.TargetControlledCreaturePermanent;

/**
 *
 * @author Styxo
 */
public class ChiefChirpa extends CardImpl {

    private static final FilterCreaturePermanent diedFilter = new FilterCreaturePermanent("a green creature you control");
    private static final FilterControlledCreaturePermanent ewokFilter = new FilterControlledCreaturePermanent("another target Ewok creature you control");

    static {
        diedFilter.add(new ColorPredicate(ObjectColor.GREEN));
        diedFilter.add(new ControllerPredicate(TargetController.YOU));

        ewokFilter.add(new SubtypePredicate("Ewok"));
        ewokFilter.add(new AnotherPredicate());
    }

    public ChiefChirpa(UUID ownerId) {
        super(ownerId, 188, "Chief Chirpa", Rarity.RARE, new CardType[]{CardType.CREATURE}, "{R}{G}{W}");
        this.expansionSetCode = "SWS";
        this.supertype.add("Legendary");
        this.subtype.add("Ewok");
        this.subtype.add("Warrior");
        this.power = new MageInt(2);
        this.toughness = new MageInt(2);

        // {2}{R}{G}{W}: Monstrosity 2.
        this.addAbility(new MonstrosityAbility("{2}{R}{G}{W}", 2));

        // Whenever a green creature you control dies, you may put a +1/+1 counter on another target Ewok creature you control.
        Ability ability = new DiesCreatureTriggeredAbility(new AddCountersTargetEffect(CounterType.P1P1.createInstance()), true, diedFilter);
        ability.addTarget(new TargetControlledCreaturePermanent(ewokFilter));
        this.addAbility(ability);

        // When Chief Chirpa become monstrous, create three 1/1 green Ewok creature tokens.
        this.addAbility(new BecomesMonstrousSourceTriggeredAbility(new CreateTokenEffect(new EwokToken(), 3)));

    }

    public ChiefChirpa(final ChiefChirpa card) {
        super(card);
    }

    @Override
    public ChiefChirpa copy() {
        return new ChiefChirpa(this);
    }
}