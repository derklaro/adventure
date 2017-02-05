package net.kyori.text;

import com.google.common.base.Objects;

import javax.annotation.Nullable;

/**
 * A scoreboard score component.
 */
public class ScoreComponent extends BaseComponent {

    /**
     * The score name.
     */
    private final String name;
    /**
     * The score objective.
     */
    private final String objective;
    /**
     * The value.
     */
    @Nullable private final String value;

    public ScoreComponent(final String name, final String objective) {
        this(name, objective, null);
    }

    public ScoreComponent(final String name, final String objective, @Nullable final String value) {
        this.name = name;
        this.objective = objective;
        this.value = value;
    }

    /**
     * Gets the score name.
     *
     * @return the score name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the objective name.
     *
     * @return the objective name
     */
    public String getObjective() {
        return this.objective;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    @Nullable
    public String getValue() {
        return this.value;
    }

    @Override
    public Component copy() {
        final ScoreComponent that = new ScoreComponent(this.name, this.objective, this.value);
        that.mergeStyle(this);
        for(final Component child : this.getChildren()) {
            that.append(child);
        }
        return that;
    }

    @Override
    public boolean equals(final Object other) {
        if(this == other) return true;
        if(other == null || !(other instanceof ScoreComponent)) return false;
        if(!super.equals(other)) return false;
        final ScoreComponent that = (ScoreComponent) other;
        return Objects.equal(this.name, that.name) && Objects.equal(this.objective, that.objective) && Objects.equal(this.value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), this.name, this.objective, this.value);
    }

    @Override
    protected void populateToString(final Objects.ToStringHelper builder) {
        builder
            .add("name", this.name)
            .add("objective", this.objective)
            .add("value", this.value);
    }
}
