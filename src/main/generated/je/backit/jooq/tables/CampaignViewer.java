/**
 * This class is generated by jOOQ
 */
package je.backit.jooq.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.5.3"
	},
	comments = "This class is generated by jOOQ"
)
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CampaignViewer extends org.jooq.impl.TableImpl<je.backit.jooq.tables.records.CampaignViewerRecord> {

	private static final long serialVersionUID = -1590532801;

	/**
	 * The reference instance of <code>public.campaign_viewer</code>
	 */
	public static final je.backit.jooq.tables.CampaignViewer CAMPAIGN_VIEWER = new je.backit.jooq.tables.CampaignViewer();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<je.backit.jooq.tables.records.CampaignViewerRecord> getRecordType() {
		return je.backit.jooq.tables.records.CampaignViewerRecord.class;
	}

	/**
	 * The column <code>public.campaign_viewer.campaign_id</code>.
	 */
	public final org.jooq.TableField<je.backit.jooq.tables.records.CampaignViewerRecord, java.lang.Integer> CAMPAIGN_ID = createField("campaign_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>public.campaign_viewer.user_id</code>.
	 */
	public final org.jooq.TableField<je.backit.jooq.tables.records.CampaignViewerRecord, java.lang.Integer> USER_ID = createField("user_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>public.campaign_viewer.view_date</code>.
	 */
	public final org.jooq.TableField<je.backit.jooq.tables.records.CampaignViewerRecord, java.sql.Timestamp> VIEW_DATE = createField("view_date", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

	/**
	 * Create a <code>public.campaign_viewer</code> table reference
	 */
	public CampaignViewer() {
		this("campaign_viewer", null);
	}

	/**
	 * Create an aliased <code>public.campaign_viewer</code> table reference
	 */
	public CampaignViewer(java.lang.String alias) {
		this(alias, je.backit.jooq.tables.CampaignViewer.CAMPAIGN_VIEWER);
	}

	private CampaignViewer(java.lang.String alias, org.jooq.Table<je.backit.jooq.tables.records.CampaignViewerRecord> aliased) {
		this(alias, aliased, null);
	}

	private CampaignViewer(java.lang.String alias, org.jooq.Table<je.backit.jooq.tables.records.CampaignViewerRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, je.backit.jooq.Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<je.backit.jooq.tables.records.CampaignViewerRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<je.backit.jooq.tables.records.CampaignViewerRecord, ?>>asList(je.backit.jooq.Keys.CAMPAIGN_VIEWER__CAMPAIGN_VIEWER_CAMPAIGN_ID_FKEY, je.backit.jooq.Keys.CAMPAIGN_VIEWER__CAMPAIGN_VIEWER_USER_ID_FKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public je.backit.jooq.tables.CampaignViewer as(java.lang.String alias) {
		return new je.backit.jooq.tables.CampaignViewer(alias, this);
	}

	/**
	 * Rename this table
	 */
	public je.backit.jooq.tables.CampaignViewer rename(java.lang.String name) {
		return new je.backit.jooq.tables.CampaignViewer(name, null);
	}
}
