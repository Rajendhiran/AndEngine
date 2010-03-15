package org.anddev.andengine.entity.particle.modifier;

import org.anddev.andengine.entity.particle.IParticleModifier;
import org.anddev.andengine.entity.particle.Particle;
import org.anddev.andengine.util.constants.TimeConstants;

/**
 * @author Nicolas Gramlich
 * @since 21:21:10 - 14.03.2010
 */
public class ExpireModifier implements IParticleModifier, TimeConstants {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	private long mMinLifeTimeNanoSeconds;
	private long mMaxLifeTimeNanoSeconds;

	// ===========================================================
	// Constructors
	// ===========================================================

	public ExpireModifier(final float pLifeTime) {
		this(pLifeTime, pLifeTime);
	}

	public ExpireModifier(final float pMinLifeTime, final float pMaxLifeTime) {
		this.mMinLifeTimeNanoSeconds = (long)(pMinLifeTime * NANOSECONDSPERSECOND);
		this.mMaxLifeTimeNanoSeconds = (long)(pMaxLifeTime * NANOSECONDSPERSECOND);
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	public long getMinLifeTimeNanoSeconds() {
		return this.mMinLifeTimeNanoSeconds;
	}

	public long getMaxLifeTimeNanoSeconds() {
		return this.mMaxLifeTimeNanoSeconds;
	}

	public void setLifeTimeNanoSeconds(final long pLifeTimeNanoSeconds) {
		this.mMinLifeTimeNanoSeconds = pLifeTimeNanoSeconds;
		this.mMaxLifeTimeNanoSeconds = pLifeTimeNanoSeconds;
	}

	public void setLifeTimeNanoSeconds(final long pMinLifeTimeNanoSeconds, final long pMaxLifeTimeNanoSeconds) {
		this.mMinLifeTimeNanoSeconds = pMinLifeTimeNanoSeconds;
		this.mMaxLifeTimeNanoSeconds = pMaxLifeTimeNanoSeconds;
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	public void onInitializeParticle(final Particle pParticle) {
		pParticle.setDeathTime(pParticle.getBirthTime() + (long)((float)Math.random() * (this.mMaxLifeTimeNanoSeconds - this.mMinLifeTimeNanoSeconds) + this.mMinLifeTimeNanoSeconds));
	}

	@Override
	public void onUpdateParticle(final Particle pParticle) {

	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
