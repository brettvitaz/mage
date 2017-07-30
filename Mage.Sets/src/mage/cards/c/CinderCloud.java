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
package mage.cards.c;

import mage.ObjectColor;
import mage.abilities.Ability;
import mage.abilities.effects.OneShotEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Outcome;
import mage.game.Game;
import mage.game.permanent.Permanent;
import mage.players.Player;
import mage.target.common.TargetCreaturePermanent;

import java.util.UUID;

/**
 *
 * @author ciaccona007
 */
public class CinderCloud extends CardImpl {

    public CinderCloud(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.INSTANT}, "{3}{R}{R}");
        

        // Destroy target creature. If a white creature dies this way, Cinder Cloud deals damage to that creature's controller equal to the creature's power.
        this.getSpellAbility().addEffect(new CinderCloudEffect());
        this.getSpellAbility().addTarget(new TargetCreaturePermanent());
    }

    public CinderCloud(final CinderCloud card) {
        super(card);
    }

    @Override
    public CinderCloud copy() {
        return new CinderCloud(this);
    }
}

class CinderCloudEffect extends OneShotEffect {

    public CinderCloudEffect() {
        super(Outcome.Benefit);
        this.staticText = "Destroy target creature. If a white creature dies this way, {this} deals damage to that creature's controller equal to the creature's power";
    }

    public CinderCloudEffect(final CinderCloudEffect effect) {
        super(effect);
    }

    @Override
    public CinderCloudEffect copy() {
        return new CinderCloudEffect(this);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Permanent permanent = game.getPermanent(getTargetPointer().getFirst(game, source));
        if(permanent != null && permanent.destroy(source.getSourceId(), game, false) && permanent.getColor(game).equals(ObjectColor.WHITE)) {
            int damage = permanent.getPower().getValue();
            Player player = game.getPlayer(permanent.getControllerId());
            if(player != null) {
                player.damage(damage, source.getSourceId(), game, false, true);
            }
        }
        return false;
    }
}