CREATE OR REPLACE FUNCTION qom.create_interaction_view(dynamicValue INT)
RETURNS VOID
AS $$
BEGIN
    EXECUTE '
    CREATE OR REPLACE VIEW qom.interaction_view AS
    SELECT i.interaction_id, it.interaction_name, i.due_date, i.indv_id
    FROM interaction i
    JOIN interaction_type it ON i.interaction_type_id = it.interaction_type_id
    WHERE i.workqueue_id = ' || dynamicValue;
END;
$$ LANGUAGE plpgsql;
